package com.lcs.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author linchenshu
 * @date 2022/7/28 10:42
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class NacosMain9003 {
    public static void main(String[] args) {
        SpringApplication.run(NacosMain9003.class,args);
    }
}
