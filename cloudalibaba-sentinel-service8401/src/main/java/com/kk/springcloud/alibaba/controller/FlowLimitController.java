package com.kk.springcloud.alibaba.controller;

/*
@author kzj
@date 2020/7/19 - 10:35
*/

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA() {
        return "-----testA";
    }

    @GetMapping("/testB")
    public String testB() {
        return "-----testB";
    }

    @GetMapping("/testHotKey") // 定义一个资源名
    @SentinelResource(value = "testHotKey", blockHandler = "deal_testHotKey")// blockHandler指定降级方法
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {
        return "------testHotKey";
    }

    public String deal_testHotKey(String p1, String p2, BlockException exception) {
        //sentinel系统默认的提示：BLocked by Sentin
        return "------deal_testHotKey,o(T-T)o";
    }
}