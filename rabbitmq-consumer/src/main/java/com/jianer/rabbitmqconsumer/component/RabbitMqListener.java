package com.jianer.rabbitmqconsumer.component;

import com.jianer.entity.UserInfo;
import com.jianer.rabbitmqconsumer.constant.RabbitMqConstant;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author 杨兴健
 * @Date 2020/4/22 16:05
 */
@Component
public class RabbitMqListener {
    private static final Logger log = LoggerFactory.getLogger(RabbitMqListener.class);

    @RabbitListener(queues = RabbitMqConstant.QUEUE_A)
    @RabbitHandler
    public void test1(UserInfo msg) {

        log.info("消费者A，收到消息:{}",msg);

    }
    @RabbitListener(queues = RabbitMqConstant.QUEUE_B)
    @RabbitHandler
    public void test2(UserInfo msg) {
        log.info("消费者B：收到消息:{}",msg);

    }
    @RabbitListener(queues = RabbitMqConstant.QUEUE_C)
    @RabbitHandler
    public void test3(UserInfo msg,Message message,Channel channel) throws IOException {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        log.info("deliveryTay:{}",deliveryTag);
        log.info("消费者C：收到信息:{}",msg);

        /*if("user".equals(msg)) {
            channel.basicReject(deliveryTag,true); //true，消息重新回到队列
            log.info("消费者C：收到消息:{},重新排队",msg);
//            log.info("消费者C：收到消息:{},消息丢弃",msg);
            return;
        }*/
    }

}
