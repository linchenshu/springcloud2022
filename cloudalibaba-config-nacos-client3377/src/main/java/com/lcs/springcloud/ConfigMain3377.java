package com.lcs.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author linchenshu
 * @date 2022/7/22 17:41
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class ConfigMain3377 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigMain3377.class,args);
    }
}
