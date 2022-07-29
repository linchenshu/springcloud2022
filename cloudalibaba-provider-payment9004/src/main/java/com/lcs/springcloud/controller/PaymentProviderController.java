package com.lcs.springcloud.controller;

import com.lcs.springcloud.entities.CommonResult;
import com.lcs.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author linchenshu
 * @date 2022/7/28 10:51
 **/
@RestController
public class PaymentProviderController {

    @Value("${server.port}")
    private String serverPort;

    /**
     * 模拟数据库
     */
    public static HashMap<Long, Payment> hashMap = new HashMap<>();
    static {
        hashMap.put(1L,new Payment(1L,"11111111111111111111111"));
        hashMap.put(2L,new Payment(2L,"22222222222222222222222"));
        hashMap.put(3L,new Payment(3L,"33333333333333333333333"));
    }

    @GetMapping("/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id){
        Payment payment = hashMap.get(id);
        CommonResult<Payment> commonResult = new CommonResult<Payment>(200, "from mysql,serverPort: " + serverPort,payment);
        return commonResult;
    }
}
