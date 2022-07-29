package com.lcs.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author linchenshu
 * @date 2022/7/11 14:08
 **/
@Service
public class HystrixService {

    public String getPayment(Long id){
        return "线程池："+Thread.currentThread().getName() + " payment_ok,id:"+ id ;
    }


    @HystrixCommand(fallbackMethod = "getPaymentHystrixTimeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")}
            )
    public String getPaymentTimeout(Long id){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        int i = 10/0;
        return "线程池："+Thread.currentThread().getName() + "payment_timeout, id:"+ id ;
    }
    String getPaymentHystrixTimeoutHandler(Long id){
        return "线程池："+Thread.currentThread().getName() + "8006 payment_timeout_handler1, id:"+ id ;
    }

    //#####################服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),//开启熔断
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
    }
    )
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if(id < 0) throw new RuntimeException("id 不能小于0");
        String simpleUUID = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "流水号："+simpleUUID;
    }

    public String  paymentCircuitBreaker_fallback(@PathVariable("id") Integer  id){
        return  " id 不能小于0 ,"+id ;
    }

}
