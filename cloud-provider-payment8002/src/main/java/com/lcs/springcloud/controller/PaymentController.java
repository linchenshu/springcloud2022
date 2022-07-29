package com.lcs.springcloud.controller;

import com.lcs.springcloud.entities.CommonResult;
import com.lcs.springcloud.entities.Payment;
import com.lcs.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author linchenshu
 * @date 2022/6/30 17:06
 **/
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @Resource
    private PaymentService paymentService;

    @PostMapping("payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("插入结果{}:",result);
        if(result > 0){
            return new CommonResult(200,"插入成功,serverPort="+serverPort,result);
        }else {
            return new CommonResult(444,"插入失败");
        }
    }
    @GetMapping("payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询结果{}:",payment);
        if(payment != null){
            return new CommonResult(200,"查询成功,serverPort="+serverPort,payment);

        }else {
            return new CommonResult(444,"查询失败");
        }
    }

    @GetMapping("/payment/lb")
    public String lb(){
        return serverPort;
    }

    @GetMapping("/payment/openFeignTimeout")
    public String openFeignTimeout(){
        try {
            TimeUnit.MILLISECONDS.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
