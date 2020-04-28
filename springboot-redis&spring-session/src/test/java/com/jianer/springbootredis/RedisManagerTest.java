package com.jianer.springbootredis;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.jianer.springbootredis.component.RedisManager;
import com.jianer.springbootredis.entity.UserInfo;
import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author 杨兴健
 * @Date 2020/4/25 11:02
 */
@SpringBootTest
public class RedisManagerTest {
    @Autowired
    RedisManager redisManager;

    @Test
    public void test1() {
        UserInfo userInfo = new UserInfo();
        userInfo.setName("yxj").setAge(30).setBirthday(LocalDateTime.now());
        System.out.println(userInfo);
        redisManager.set("user",userInfo);
    }
    @Test
    public void test2() {
        Object user = redisManager.get("user");
        System.out.println(user);


    }
    @Test
    public void test3() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY)
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .registerModule(new JavaTimeModule())
                .enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);


        LocalDateTime now = LocalDateTime.now();


        System.out.println(now);
        String s = mapper.writeValueAsString(now);
        System.out.println(s);
    }
}
