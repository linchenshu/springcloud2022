package com.lcs.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lcs.springcloud.entities.CommonResult;
import com.lcs.springcloud.entities.Payment;
import com.lcs.springcloud.myhandler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author linchenshu
 * @date 2022/7/27 10:17
 **/
@RestController
public class RateLimitController {
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handleException")
    public CommonResult byResource(){
        return new CommonResult(200,"按资源名称限流测试ok",new Payment(2022L,"serial001"));
    }
    public CommonResult handleException(BlockException exception){
        return new CommonResult(444,exception.getClass().getCanonicalName()+"\t 服务不可用！");
    }
    @GetMapping("/byUrl")
    @SentinelResource(value = "byUrl" )
    public CommonResult byUrl(){
        return new CommonResult(200,"按url限流测试ok",new Payment(2022L,"serial001"));
    }

    @GetMapping("/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler" ,blockHandlerClass = CustomerBlockHandler.class,blockHandler = "handlerException2")
    public CommonResult customerBlockHandler(){
        return new CommonResult(200,"按客服自定义限流测试ok",new Payment(2022L,"serial001"));
    }
}
