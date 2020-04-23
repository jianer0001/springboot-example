package com.jianer.springbootinterceptor.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 杨兴健
 * @Date 2020/4/21 22:56
 */
@RestController
public class LoginController {

    @PostMapping("/user/login")
    public String login(String username) {
        return username + " :登录成功";
    }

    @PostMapping("/fail")
    public String error() {
        return "登录失败";
    }
}
