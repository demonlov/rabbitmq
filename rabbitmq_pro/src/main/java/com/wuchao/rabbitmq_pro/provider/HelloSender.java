package com.wuchao.rabbitmq_pro.provider;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author WuChao
 * @version 1.0
 * @date 2020/2/26 11:12
 */
@Component
public class HelloSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    public void send() {
        rabbitTemplate.convertAndSend("hello","你好");
    }


}
