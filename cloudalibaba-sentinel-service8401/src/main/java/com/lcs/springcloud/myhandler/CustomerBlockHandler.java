package com.lcs.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lcs.springcloud.entities.CommonResult;
import com.lcs.springcloud.entities.Payment;

/**
 * @author linchenshu
 * @date 2022/7/27 17:40
 **/
public class CustomerBlockHandler {
    public static CommonResult handlerException(BlockException exception){
        return new CommonResult(2022,"自定义限流处理 ---- CustomerBlockHandler");
    }
    public static CommonResult handlerException2(BlockException exception){
        return new CommonResult(2022,"自定义限流处理2 ---- CustomerBlockHandler2");
    }
}
