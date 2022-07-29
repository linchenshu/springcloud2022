package com.lcs.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author linchenshu
 * @date 2022/7/11 15:54
 **/
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = HystrixServiceFallback.class)
public interface PaymentHystrixService {

    @GetMapping("/payment/getPaymentOk/{id}")
    String getPayment(@PathVariable("id") Long id);

    @GetMapping("/payment/getPaymentTimeout/{id}")
    String getPaymentTimeout(@PathVariable("id") Long id);

}
