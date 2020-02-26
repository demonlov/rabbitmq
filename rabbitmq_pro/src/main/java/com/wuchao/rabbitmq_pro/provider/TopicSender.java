package com.wuchao.rabbitmq_pro.provider;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author WuChao
 * @version 1.0
 * @date 2020/2/26 11:44
 */
@Component
public class TopicSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    public void send1() {
        String context = "hi, i am message 1";
        System.out.println("Sender : " + context);
       rabbitTemplate.convertAndSend("topicExchange", "topic.message", context);
    }

    public void send2() {
        String context = "hi, i am messages 2";
        System.out.println("Sender : " + context);
       rabbitTemplate.convertAndSend("topicExchange", "topic.messages", context);
    }


}
