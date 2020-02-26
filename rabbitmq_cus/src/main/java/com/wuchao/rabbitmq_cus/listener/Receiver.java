package com.wuchao.rabbitmq_cus.listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author WuChao
 * @version 1.0
 * @date 2020/2/26 11:17
 */
@Component
public class Receiver {

    @RabbitHandler
    @RabbitListener(queues = "hello")
    public void process(String hello) {
        System.out.println("Receiver  : " + hello);
    }


    @RabbitHandler
    @RabbitListener(queues = "topic.message")
    public void process1(String message) {
        System.out.println("Topic Receiver1  : " + message);
    }

    @RabbitHandler
    @RabbitListener(queues = "topic.messages")
    public void process2(String message) {
        System.out.println("Topic Receiver2  : " + message);
    }

    @RabbitHandler
    @RabbitListener(queues = "credit.bank")
    public void creditBank(String msg) {
        System.out.println("credit.bank receive message: " + msg);
    }

    @RabbitHandler
    @RabbitListener(queues = "credit.finance")
    public void creditFinance(String msg) {
        System.out.println("credit.bank receive message: " + msg);
    }

    @RabbitHandler
    @RabbitListener(queues = "fanout.A")
    public void processFanoutA(String message) {
        System.out.println("fanout Receiver A  : " + message);
    }

    @RabbitHandler
    @RabbitListener(queues = "fanout.B")
    public void processFanoutB(String message) {
        System.out.println("fanout Receiver B  : " + message);
    }
    @RabbitHandler
    @RabbitListener(queues = "fanout.C")
    public void processFanoutC(String message) {
        System.out.println("fanout Receiver C  : " + message);
    }

}