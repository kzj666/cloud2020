package com.kk.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/*
@author kzj
@date 2020/7/15 - 15:17
*/
@Service
public class PaymentService {

    /**
     * 正常的方法
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id){
        return "线程池:"+Thread.currentThread().getName()+"\t"+"paymentInfo_OK，id: "+ id +"\t"+ "O(∩_∩)O哈哈~" ;
    }

    /**
     * 模拟超时，使其降级
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOut_Handler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentInfo_TimeOut(Integer id){
//        int time = 5000;
        int time = 3000;
//        int i = 1/0;
        try {
            TimeUnit.MILLISECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:"+Thread.currentThread().getName()+"\t"+"paymentInfo_TimeOut，id: "+ id +"\t"+ "┭┮﹏┭┮" +"耗时（秒）："+time;
    }

    public String paymentInfo_TimeOut_Handler(Integer id){
        return "线程池:"+Thread.currentThread().getName()+"\t"+"系统繁忙或者运行报错，请稍后再试!"+"\t"+"o(*￣︶￣*)o" ;
    }



    // 服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),// 请求次数峰值
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),// 时间窗口期，失败后等待多久再进行重试，单位为毫秒
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")// 失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if(id < 0){
            throw new RuntimeException("=============id不能为负数============");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t"+"调用成功，流水号为"+serialNumber;
    }
    // 对应的降级方法
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id不能为负数，请稍后再试，id为"+id;
    }



}
