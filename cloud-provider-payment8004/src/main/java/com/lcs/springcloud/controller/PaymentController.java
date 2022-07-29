package com.lcs.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author linchenshu
 * @date 2022/7/4 11:24
 **/
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("payment/zk")
    public String getServerPort(){
        return "zookeeper:"+serverPort+","+ UUID.randomUUID().toString();
    }
}
