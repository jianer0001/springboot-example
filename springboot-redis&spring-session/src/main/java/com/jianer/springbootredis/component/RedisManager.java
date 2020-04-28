package com.jianer.springbootredis.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.PartialUpdate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author 杨兴健
 * @Date 2020/4/25 10:37
 */
@Component
public class RedisManager {

    @Resource
    RedisTemplate redisTemplate;

    public void set(String key,Object value) {
        ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();
        opsForValue.set(key,value);
    }

    public Object get(String key) {
        ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();
        return opsForValue.get(key);
    }
}
