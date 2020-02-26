package com.wuchao.rabbitmq_pro.provider;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author WuChao
 * @version 1.0
 * @date 2020/2/26 14:15
 */
@Component
public class ApiCreditSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void creditBank(Map<String, Object> head, String msg){
        System.out.println("credit.bank send message: "+msg);
        rabbitTemplate.convertAndSend("creditBankExchange", "credit.bank", getMessage(head, msg));
    }

    public void creditFinance(Map<String, Object> head, String msg){
        System.out.println("credit.finance send message: "+msg);
        rabbitTemplate.convertAndSend("creditFinanceExchange", "credit.finance", getMessage(head, msg));
    }

    private Message getMessage(Map<String, Object> head, Object msg){
        MessageProperties messageProperties = new MessageProperties();
        for (Map.Entry<String, Object> entry : head.entrySet()) {
            messageProperties.setHeader(entry.getKey(), entry.getValue());
        }
        SimpleMessageConverter messageConverter = new SimpleMessageConverter();
        return messageConverter.toMessage(msg, messageProperties);
    }


}
