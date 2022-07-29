package com.lcs.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author linchenshu
 * @date 2022/7/22 16:05
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class NacosMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(NacosMain9001.class,args);
    }
}
