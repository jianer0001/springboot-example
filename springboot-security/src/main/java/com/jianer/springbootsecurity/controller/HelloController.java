package com.jianer.springbootsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 杨兴健
 * @Date 2020/4/17 21:00
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello,security!";
    }

    @RequestMapping("/admin/hello")
    public String admin() {
        return "hello,admin";
    }
    @RequestMapping("/user/hello")
    public String user() {
        return "hello,user";
    }

    @RequestMapping("/")
    public String index() {
        return "hello,index";
    }
    @RequestMapping("/success")
    public String success() {
        return "hello,success";
    }
    @RequestMapping("/f1")
    public String fail1() {
        return "hello,f1";
    }
    @RequestMapping("/f2")
    public String fail2() {
        return "hello,f2";
    }
    @RequestMapping("/logout1")
    public String logout() {
        return "hello,logout";
    }



}
