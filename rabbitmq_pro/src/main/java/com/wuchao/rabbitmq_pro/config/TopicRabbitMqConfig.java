package com.wuchao.rabbitmq_pro.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author WuChao
 * @version 1.0
 * @date 2020/2/26 11:41
 */
@Configuration
/**
 *Topic 转发信息主要是依据通配符,队列和交换机的绑定主要是依据一种模式(通配符+字符串),
 * 而当发送消息的时候,只有指定的Key和该模式相匹配的时候,消息才会被发送到该消息队列中。
 */
public class TopicRabbitMqConfig {
    final static String message = "topic.message";
    final static String messages = "topic.messages";
    // 创建队列
    @Bean
    public Queue queueMessage() {
        return new Queue(TopicRabbitMqConfig.message);
    }
    // 创建队列
    @Bean
    public Queue queueMessages() {
        return new Queue(TopicRabbitMqConfig.messages);
    }
    // 将对列绑定到Topic交换器
    @Bean
    TopicExchange exchange() {
        return new TopicExchange("topicExchange");
    }
    // 将对列绑定到Topic交换器
    @Bean
    Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }
    // 将对列绑定到Topic交换器 采用#的方式
    @Bean
    Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
    }

}
