package com.jianer.rabbitmqconsumer.component;

import com.jianer.entity.UserInfo;
import com.jianer.rabbitmqconsumer.constant.RabbitMqConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author 杨兴健
 * @Date 2020/4/22 16:05
 */
@Component
public class RabbitMqListener2 {
    private static final Logger log = LoggerFactory.getLogger(RabbitMqListener2.class);

    @RabbitListener(queues = RabbitMqConstant.QUEUE_C)
    @RabbitHandler
    public void test3( Message message) {
        Long l = (Long) message.getHeaders().get(AmqpHeaders.DELIVERY_TAG);
        UserInfo payload = (UserInfo)message.getPayload();
        log.info("deliveryTay:{}",l);
//        log.info("消费者C-1：收到消息:{}",msg);
        log.info("消费者C-1-1：收到消息:{}",payload);

    }

}
