package com.lcs.springcloud.dao;

import com.lcs.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author linchenshu
 * @date 2022/6/30 16:39
 **/
@Mapper
public interface PaymentDao {
    int create(Payment payment);
    Payment getPaymentById(Long id);
}
