package com.wuchao.rabbitmq_pro.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author WuChao
 * @version 1.0
 * @date 2020/2/26 11:10
 */
@Configuration
public class RabbitMqConfigDirect {

@Bean
    public Queue hello() {
    return new Queue("hello");
}


}
