package com.lcs.springcloud.service.impl;

import com.lcs.springcloud.dao.PaymentDao;
import com.lcs.springcloud.entities.Payment;
import com.lcs.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author linchenshu
 * @date 2022/6/30 17:03
 **/
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;
    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
