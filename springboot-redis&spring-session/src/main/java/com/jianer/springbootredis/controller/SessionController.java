package com.jianer.springbootredis.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 杨兴健
 * @Date 2020/4/26 14:24
 */
@RestController
@RequestMapping("/session")
public class SessionController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
