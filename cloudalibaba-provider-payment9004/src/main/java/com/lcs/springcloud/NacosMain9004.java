package com.lcs.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author linchenshu
 * @date 2022/7/28 10:43
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class NacosMain9004 {
    public static void main(String[] args) {
        SpringApplication.run(NacosMain9004.class,args);
    }
}
