package com.lcs.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author linchenshu
 * @date 2022/7/25 15:08
 **/
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA(){
        return "-------testA";
    }

    @GetMapping("testB")
    public String testB(){
        log.info(Thread.currentThread().getName());
        return "------------testB";
    }
    @GetMapping("testD")
    public String testD(){
//        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace();}
//        log.info(Thread.currentThread().getName());
        int i = 10/0;
        log.info("异常比例");
        return "------------testD";
    }

    @GetMapping("testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "block_testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2){
//        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace();}
//        log.info(Thread.currentThread().getName());
        log.info("热点");
        return "------------testHotKey";
    }

    public String block_testHotKey(String p1, String p2, BlockException exception){
        return "------------block_testHotKey";
    }
}
