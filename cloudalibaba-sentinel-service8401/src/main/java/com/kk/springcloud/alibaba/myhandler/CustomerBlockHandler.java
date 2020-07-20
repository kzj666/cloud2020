package com.kk.springcloud.alibaba.myhandler;

/*
@author kzj
@date 2020/7/19 - 17:19
*/

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.kk.springcloud.entity.CommonResult;


public class CustomerBlockHandler {
    public static CommonResult handlerException(BlockException exception) {
        return new CommonResult(4444, "按客户自定义，global handlerException---1");
    }
    public static CommonResult handlerException2(BlockException exception) {
        return new CommonResult(4444, "按客户自定义，global handlerException----2");
    }
}
