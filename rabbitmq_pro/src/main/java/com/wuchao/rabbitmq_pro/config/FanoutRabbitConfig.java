package com.wuchao.rabbitmq_pro.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author WuChao
 * @version 1.0
 * @date 2020/2/26 14:33
 */
@Configuration
public class FanoutRabbitConfig {
    /**
     * FanoutExchange交换机是转发消息到所有绑定队列（和routingKey没有关系）,
     * 即我们熟悉的广播模式或者订阅模式，
     * 给Fanout交换机发送消息，绑定了这个交换机的所有队列都收到这个消息。
     */

// 创建队列
    @Bean
    public Queue AMessage() {
        return new Queue("fanout.A");
    }
    // 创建队列
    @Bean
    public Queue BMessage() {
        return new Queue("fanout.B");
    }
    // 创建队列
    @Bean
    public Queue CMessage() {
        return new Queue("fanout.C");
    }
    // 创建Fanout交换器
    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");
    }
    // 将对列绑定到Fanout交换器
    @Bean
    Binding bindingExchangeA(Queue AMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(AMessage).to(fanoutExchange);
    }
    // 将对列绑定到Fanout交换器
    @Bean
    Binding bindingExchangeB(Queue BMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(BMessage).to(fanoutExchange);
    }
    // 将对列绑定到Fanout交换器
    @Bean
    Binding bindingExchangeC(Queue CMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(CMessage).to(fanoutExchange);
    }
}
