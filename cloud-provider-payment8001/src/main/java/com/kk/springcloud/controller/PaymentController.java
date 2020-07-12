package com.kk.springcloud.controller;

import com.kk.springcloud.entity.CommonResult;
import com.kk.springcloud.entity.Payment;
import com.kk.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Payment)表控制层
 *
 * @author makejava
 * @since 2020-07-11 13:07:31
 */
@Slf4j
@RestController
@RequestMapping("payment")
public class PaymentController {

    @Resource
    private DiscoveryClient discoveryclient;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private PaymentService paymentService;

    @PostMapping("create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("-----------插入结果----------");
        if (result > 0){
            return new CommonResult(200,"插入数据成功"+"，服务端口为："+serverPort, result);
        }else {
            return new CommonResult(444,"插入数据失败",null);
        }
    }

    @GetMapping("get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("-----------插入结果"+ payment +"----------");
        if (payment != null){
            return new CommonResult(200,"查询成功"+"，服务端口为："+serverPort, payment);
        }else {
            return new CommonResult(444,"没有记录，查询失败，查询id为："+id,null);
        }
    }

    @GetMapping("discovery")
    public Object discovery(){
        List<String> services = discoveryclient.getServices();
        for (String element : services) {
            log.info("--------element--------"+element);
        }
        List<ServiceInstance> instances = discoveryclient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            System.out.println(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return discoveryclient;
    }


}