package com.kk.springcloud.service.impl;

/*
@author kzj
@date 2020/7/18 - 10:17
*/

import com.kk.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import javax.annotation.Resource;
import java.util.UUID;

@EnableBinding(Source.class)// 表示当前这个类是source，负责生产消息，并且发送给channel
public class MessageProviderImpl implements IMessageProvider {

    // channel,我们将消息发送给channel
    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        // 构建消息发送，build方法会构建一个Message类
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("*****************serical:"+serial);
        return null;
    }
}
