package com.lcs.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author linchenshu
 * @date 2022/7/5 16:22
 **/
@SpringBootApplication
@EnableFeignClients
public class OpenFeignOrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OpenFeignOrderMain80.class,args);
    }
}
