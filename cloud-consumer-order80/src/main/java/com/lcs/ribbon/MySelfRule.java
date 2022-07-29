package com.lcs.ribbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author linchenshu
 * @date 2022/7/4 17:38
 **/

@Configuration
public class MySelfRule {
    @Bean
    public IRule getMySelfRule(){
        return new RandomRule();
    }
}
