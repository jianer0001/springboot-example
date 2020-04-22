package com.jianer.rabbitmqprovider.controller;

import com.jianer.rabbitmqprovider.constant.RabbitMqConstant;
import com.jianer.entity.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author 杨兴健
 * @Date 2020/4/22 15:37
 */
@RestController
public class TestController {
    private static final Logger log = LoggerFactory.getLogger(TestController.class);

    @Autowired
    RabbitTemplate rabbitTemplate;

    @GetMapping("/hello")
    public String hello(UserInfo user) {
        if (user != null ) {
            String messageId = UUID.randomUUID().toString();
            rabbitTemplate.convertAndSend(RabbitMqConstant.EXCHANGE_A,null,user,new CorrelationData(messageId));
            log.info("消息已发送,messageId:{}",messageId);
            return "消息已发送";
        }
        return "不发送信息";
    }
}
