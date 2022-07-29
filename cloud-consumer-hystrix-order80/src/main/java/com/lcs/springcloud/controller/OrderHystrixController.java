package com.lcs.springcloud.controller;

import com.lcs.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author linchenshu
 * @date 2022/7/11 15:56
 **/
@RestController
//@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {

    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/getPaymentOk/{id}")
    String getPayment(@PathVariable("id") Long id){
        return paymentHystrixService.getPayment(id);
    }

//    @HystrixCommand
    @GetMapping("/consumer/payment/getPaymentTimeout/{id}")
    public String getPaymentTimeout(@PathVariable("id") Long id){
//        int i = 10/0;
        return paymentHystrixService.getPaymentTimeout(id) ;
    }
    String getPaymentHystrixTimeoutHandler(Long id){
        return "线程池："+Thread.currentThread().getName() + "80 payment_timeout_handler1, id:"+ id ;
    }
    String payment_Global_FallbackMethod(){
        return "线程池："+Thread.currentThread().getName() + ":80, payment_Global_FallbackMethod" ;
    }

}
