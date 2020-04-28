package com.jianer.springbootjwt.controller;

import com.jianer.springbootjwt.annotation.NotControllerResponseAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 杨兴健
 * @Date 2020/4/28 20:00
 */
@RestController
public class HealthController {

    @GetMapping("/health")
    @NotControllerResponseAdvice
    public String health() {
        return "success";
    }
}
