package com.lcs.springcloud.controller;

import com.lcs.springcloud.service.HystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author linchenshu
 * @date 2022/7/11 14:12
 **/
@RestController
public class HystrixPaymentController {
    @Autowired
    private HystrixService hystrixService;

    @GetMapping("/payment/getPaymentOk/{id}")
    String getPayment(@PathVariable("id") Long id){
        return hystrixService.getPayment(id);
    }

    @GetMapping("/payment/getPaymentTimeout/{id}")
    String getPaymentTimeout(@PathVariable("id") Long id){
        return hystrixService.getPaymentTimeout(id) ;
    }

    @GetMapping("/payment/circuit/{id}")
    String getPaymentTimeout(@PathVariable("id") Integer  id){
        return hystrixService.paymentCircuitBreaker(id) ;
    }
}
