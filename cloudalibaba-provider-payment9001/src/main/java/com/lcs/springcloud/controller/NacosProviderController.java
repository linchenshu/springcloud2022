package com.lcs.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author linchenshu
 * @date 2022/7/22 16:06
 **/
@RestController
public class NacosProviderController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/nacos/port")
    public String nacos(){
        return serverPort;
    }
}
