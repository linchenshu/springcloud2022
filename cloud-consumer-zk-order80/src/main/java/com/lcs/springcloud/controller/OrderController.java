package com.lcs.springcloud.controller;

import com.lcs.springcloud.entities.CommonResult;
import com.lcs.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author linchenshu
 * @date 2022/7/4 15:09
 **/
@RestController
@Slf4j
public class OrderController {
    private static final String PAYMENT_URL = "http://cloud-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/zk")
    public String getPaymentInfo(){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/zk",String.class);
    }
}
