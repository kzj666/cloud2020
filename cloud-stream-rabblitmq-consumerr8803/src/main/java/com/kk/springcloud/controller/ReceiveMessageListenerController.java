package com.kk.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/*
@author kzj
@date 2020/7/18 - 11:22
*/
@Component
@EnableBinding(Sink.class)// 启动绑定，就是表示当前类是sink，负责接收channel发送过来的数据
public class ReceiveMessageListenerController {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)// 这里表示监听sink的input，而input我们在配置文件中配置了，绑定在了指定Exchange上获取数据
    public void input(Message<String> message){
        System.out.println("我是消费者8802号------->接收到的消息：" + message.getPayload()+"\t"+serverPort);
    }
}
