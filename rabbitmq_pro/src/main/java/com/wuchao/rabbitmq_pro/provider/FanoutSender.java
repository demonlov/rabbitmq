package com.wuchao.rabbitmq_pro.provider;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author WuChao
 * @version 1.0
 * @date 2020/2/26 14:36
 */
@Component
public class FanoutSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    public void send() {
        String context = "hi, fanout msg ";
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("fanoutExchange","", context);
    }
}
