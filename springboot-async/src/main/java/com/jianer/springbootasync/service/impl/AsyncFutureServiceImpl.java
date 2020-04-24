package com.jianer.springbootasync.service.impl;

import com.jianer.springbootasync.service.AsyncFutureService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.Future;

/**
 * @author 杨兴健
 * @Date 2020/4/24 12:07
 */
@Service
public class AsyncFutureServiceImpl implements AsyncFutureService {
    @Override
    @Async("myExecutor")
    public Future<String> fun() {
        System.out.println("---异步任务处理中---");
        String[] names = {"yxj","ccy","yxw","yhp"};
        String name = names[new Random().nextInt(4)];
        try {
            Thread.sleep(3*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new AsyncResult<String>(name);
    }
}
