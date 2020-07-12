package com.kk.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

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

    @RequestMapping("zk")
    public String paymentzk() {
        return "springcloud with zookeeper:" + serverPort + "\t" + UUID.randomUUID().toString();
    }

}