package com.lcs.springcloud.service;

import com.lcs.springcloud.entities.Payment;

/**
 * @author linchenshu
 * @date 2022/6/30 17:03
 **/
public interface PaymentService {
    int create(Payment payment);
    Payment getPaymentById(Long id);
}
