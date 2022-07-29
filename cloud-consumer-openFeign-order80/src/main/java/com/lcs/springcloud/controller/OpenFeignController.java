package com.lcs.springcloud.controller;

import com.lcs.springcloud.entities.CommonResult;
import com.lcs.springcloud.entities.Payment;
import com.lcs.springcloud.service.OpenFeignPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author linchenshu
 * @date 2022/7/5 16:26
 **/
@RestController
public class OpenFeignController {

    @Autowired
    private OpenFeignPaymentService openFeignPaymentService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        return openFeignPaymentService.getPaymentById(id);
    }
    @GetMapping("/consumer/payment/openFeignTimeout")
    public String openFeignTimeout(){
        return openFeignPaymentService.openFeignTimeout();
    }
}
