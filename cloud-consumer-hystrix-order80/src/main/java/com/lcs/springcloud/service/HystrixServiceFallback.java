package com.lcs.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author linchenshu
 * @date 2022/7/12 11:12
 **/
@Component
public class HystrixServiceFallback implements PaymentHystrixService {

    @Override
    public String getPayment(Long id) {
        return " fallback payment ok ";
    }

    @Override
    public String getPaymentTimeout(Long id) {
        return "fallback paymentimeout ";
    }
}
