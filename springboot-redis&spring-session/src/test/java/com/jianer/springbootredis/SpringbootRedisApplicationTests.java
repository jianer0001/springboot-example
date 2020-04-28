package com.jianer.springbootredis;

import com.jianer.springbootredis.component.StringRedisManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootRedisApplicationTests {
    @Autowired
    StringRedisManager stringRedisManager;

    @Test
    void contextLoads() {
       stringRedisManager.set("name","yxj");
    }
    @Test
    void test1() {
        System.out.println(stringRedisManager.getExpire("name"));
    }
    @Test
    void test3() {
        System.out.println(stringRedisManager.get("name"));
    }
    @Test
    void test2() {
        System.out.println(stringRedisManager.delete("name"));
    }

}
