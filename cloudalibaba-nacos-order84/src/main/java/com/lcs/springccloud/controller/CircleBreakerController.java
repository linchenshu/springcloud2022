package com.lcs.springccloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lcs.springcloud.entities.CommonResult;
import com.lcs.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author linchenshu
 * @date 2022/7/28 10:57
 **/
@RestController
@Slf4j
public class CircleBreakerController {

    @Value("${service-url.nacos-user-service}")
    private String serviceUrl;
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("consumer/fallback/{id}")
//    @SentinelResource(value = "fallback")
//    @SentinelResource(value = "fallback",fallback = "handlerFallback")//只负责业务异常
//    @SentinelResource(value = "fallback",blockHandler = "blockHandler")//sentinel控制台的配置违规
    @SentinelResource(value = "fallback",blockHandler = "blockHandler",fallback = "handlerFallback",
            exceptionsToIgnore = {IllegalArgumentException.class}) //exceptionsToIgnore:忽略异常 blockHandler > fallback
    public CommonResult<Payment> fallback(@PathVariable("id") Long id){
        CommonResult result = restTemplate.getForObject(serviceUrl + "/paymentSQL/" + id, CommonResult.class, id);
        if(id == 4){
            throw new IllegalArgumentException("IllegalArgumentException,非法参数异常。。。。。。");
        }else if (result.getData() == null){
            throw new NullPointerException("NullPointerException,该id没有记录，空指针异常");
        }
        return result;
    }

    public CommonResult<Payment> handlerFallback(@PathVariable() Long id,Throwable e){
        Payment payment = new Payment(id, null);
        return new CommonResult(444,"兜底异常，exception内容："+e.getMessage(),payment);
    }
    public CommonResult<Payment> blockHandler(@PathVariable() Long id, BlockException e){
        Payment payment = new Payment(id, null);
        return new CommonResult(445,"blockHandler-sentinel限流，无此流水，blockException："+e.getMessage(),payment);
    }
}
