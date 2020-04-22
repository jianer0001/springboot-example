package com.jianer.rabbitmqprovider.config;

import com.jianer.rabbitmqprovider.constant.RabbitMqConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 杨兴健
 * @Date 2020/4/22 14:44
 */
@Configuration
public class RabbitMQConfig {

    private static final Logger log = LoggerFactory.getLogger(RabbitMQConfig.class);

    @Autowired
    CachingConnectionFactory cachingConnectionFactory;

    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(cachingConnectionFactory);

        rabbitTemplate.setConfirmCallback((correlationData, b, s) -> {
            String id = correlationData.getId();
            if(b) {
                log.info("消息放送成功，信息id为:{}",id);
            }else {
                log.info("信息发送失败，信息id为:{}",id);
            }
        });
        rabbitTemplate.setReturnCallback((message, i, s, s1, s2) -> {
            log.info("消息发送到rabbitMQ,但找不到相应的队列");
        });
        return rabbitTemplate;
    }

    @Bean
    public Queue queueA() {
        return new Queue(RabbitMqConstant.QUEUE_A);
    }
    @Bean
    public Queue queueB() {
        return new Queue(RabbitMqConstant.QUEUE_B);
    }
    @Bean
    public Queue queueC() {
        return new Queue(RabbitMqConstant.QUEUE_C);
    }

    @Bean
    public FanoutExchange exchangeA() {
        return new FanoutExchange(RabbitMqConstant.EXCHANGE_A,false,false);
    }

    @Bean
    public Binding bindingA() {
        return BindingBuilder.bind(queueA()).to(exchangeA());
    }
    @Bean
    public Binding bindingB() {
        return BindingBuilder.bind(queueB()).to(exchangeA());
    }
    @Bean
    public Binding bindingC() {
        return BindingBuilder.bind(queueC()).to(exchangeA());
    }

}
