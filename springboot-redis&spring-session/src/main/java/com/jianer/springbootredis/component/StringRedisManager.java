package com.jianer.springbootredis.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * @author 杨兴健
 * @Date 2020/4/24 20:18
 */
@Component
public class StringRedisManager {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    /**
     * 保存key和value，设置过期时间
     * @param key
     * @param value
     * @param seconds
     */
    public void set(String key,String value,long seconds) {
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        if (seconds == 0) {
            operations.set(key,value);
            return;
        }
        operations.set(key, value,Duration.ofSeconds(seconds));
    }

    /**
     * 保存key和value
     * @param key
     * @param value
     */
    public void set(String key,String value) {
        set(key,value,0);
    }
    public Boolean setIfAbsent(String key,String value,long seconds) {
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        Boolean flag = operations.setIfAbsent(key, value, Duration.ofSeconds(seconds));
        return flag;
    }

    /**
     * 删除key
     * @param key
     * @return
     */
    public Boolean delete(String key) {
        return stringRedisTemplate.delete(key);
    }

    /**
     * 更新key
     * @param key
     * @param value
     * @return 返回旧key
     */
    public String update(String key,String value) {
        ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();
        return opsForValue.getAndSet(key,value);
    }

    /**
     * 判断是否存在key
     * @param key
     * @return
     */
    public Boolean hasKey(String key) {
        return stringRedisTemplate.hasKey(key);
    }

    /**
     * 根据key获取value
     * @param key
     * @return
     */
    public String get(String key) {
        ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();
        return opsForValue.get(key);
    }

    /**
     * 获取key的过期时间
     * @param key
     * @return
     */
    public Long getExpire(String key) {
        return stringRedisTemplate.getExpire(key);
    }

    /**
     * 设置key的过期时间
     * @param key
     * @param time 单位秒
     * @return
     */
    public Boolean setExpire(String key,long time) {
        return stringRedisTemplate.expire(key, time, TimeUnit.SECONDS);
    }
}
