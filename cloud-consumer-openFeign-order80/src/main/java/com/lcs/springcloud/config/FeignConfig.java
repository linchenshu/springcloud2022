package com.lcs.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author linchenshu
 * @date 2022/7/5 17:26
 * feign日志增强
 **/
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLeaver(){
        return Logger.Level.FULL;
    }
}
