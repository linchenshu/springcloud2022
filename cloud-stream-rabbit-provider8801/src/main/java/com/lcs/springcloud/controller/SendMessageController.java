package com.lcs.springcloud.controller;

import com.lcs.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author linchenshu
 * @date 2022/7/18 10:33
 **/
@RestController
public class SendMessageController {
    @Resource
    private IMessageProvider messageProvider;

    @GetMapping("/send")
    public void send(){
        messageProvider.send();
    }


}
