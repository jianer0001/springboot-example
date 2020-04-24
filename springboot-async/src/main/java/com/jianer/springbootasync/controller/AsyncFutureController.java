package com.jianer.springbootasync.controller;

import com.jianer.springbootasync.service.AsyncFutureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

/**
 * @author 杨兴健
 * @Date 2020/4/24 12:10
 */
@RestController
public class AsyncFutureController {
    @Autowired
    AsyncFutureService asyncFutureService;

    @GetMapping("/fun")
    public String fun() throws Exception {
        Future<String> future = asyncFutureService.fun();
        for (int i = 0; i < 50; i++) {
            if(future.isDone()) {
                String name = future.get();
                System.out.println("选中的名字是:" + name);
                return name;
            }
            System.out.println("还没有处理完，先睡一会>>>>>:" + i);
            Thread.sleep(100);
        }
        return "处理失败";
    }
}
