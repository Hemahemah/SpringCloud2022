package com.atguigu.cloudalibaba.config;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zlh.springcloud.entities.CommonResult;

/**
 * @author lh
 */

public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException exception){
        return new CommonResult(4444, "按客户自定义, global handlerException----1");
    }

    public static CommonResult handlerException2(BlockException e) {
        return new CommonResult(4444, "按客户自定义, global handlerException----2");
    }
}
