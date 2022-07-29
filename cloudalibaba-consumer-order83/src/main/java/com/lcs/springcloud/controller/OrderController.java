package com.lcs.springcloud.controller;

import com.lcs.springcloud.entities.CommonResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author linchenshu
 * @date 2022/7/22 17:06
 **/
@RestController
public class OrderController {

    @Value("${service-url.nacos-user-service}")
    private String serviceUrl;
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("consumer/payment/nacos/port")
    public String port(){
        System.out.println(serviceUrl);
        return restTemplate.getForObject(serviceUrl+"/payment/nacos/port/",String.class);
    }
}
