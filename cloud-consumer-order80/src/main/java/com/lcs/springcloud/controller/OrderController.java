package com.lcs.springcloud.controller;

import com.lcs.springcloud.entities.CommonResult;
import com.lcs.springcloud.entities.Payment;
import com.lcs.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author linchenshu
 * @date 2022/6/30 17:06
 **/
@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderController {

//    private static final String PAYMENT_URL = "http://localhost:8001";
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private LoadBalancer loadBalancer;
    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/payment/create")
    public CommonResult<Payment> create(Payment payment){
       return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }
    @GetMapping("payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }
    @GetMapping("payment/getForEntity/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id){
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if(entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }else{
            return new CommonResult(444,"查询出错");
        }
    }

    @GetMapping("/payment/lb")
    public String lb(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if(instances.isEmpty()) return null;
        ServiceInstance instance = loadBalancer.instances(instances);
        return restTemplate.getForObject(instance.getUri()+"/payment/lb",String.class);
    }

    @GetMapping("/payment/zipkin")
    public String zipkin(){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/zipkin",String.class);
    }
}
