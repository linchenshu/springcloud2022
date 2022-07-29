package com.lcs.springcloud.service;

import com.lcs.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author linchenshu
 * @date 2022/7/5 16:25
 **/
@Component
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface OpenFeignPaymentService {
    @GetMapping("/payment/get/{id}")
    CommonResult getPaymentById(@PathVariable("id") Long id);

    @GetMapping("/payment/openFeignTimeout")
    String openFeignTimeout();
}
