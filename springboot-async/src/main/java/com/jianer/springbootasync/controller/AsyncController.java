package com.jianer.springbootasync.controller;

import com.jianer.springbootasync.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 杨兴健
 * @Date 2020/4/23 9:40
 */
@RestController
public class AsyncController {

    @Autowired
    AsyncService asyncService;

    @GetMapping("/async")
    public String async() throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            asyncService.show2();
//            asyncService.show(i);
        }
        return "ok";
    }
}
