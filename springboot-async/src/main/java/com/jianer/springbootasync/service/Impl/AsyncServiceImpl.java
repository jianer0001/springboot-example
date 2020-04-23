package com.jianer.springbootasync.service.Impl;

import com.jianer.springbootasync.service.AsyncService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author 杨兴健
 * @Date 2020/4/22 23:34
 */
@Service
public class AsyncServiceImpl implements AsyncService {

    @Override
    @Async()
    public void show(int i) {
        String name = Thread.currentThread().getName();
        try {
            Thread.sleep(6*1000);
            System.out.println(name + ":" + i + ": 书山有路勤为径");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    @Async("myExecutor")
    public void show2() {
        String name = Thread.currentThread().getName();
        try {
            Thread.sleep(5000);
            System.out.println(name + ": 学海无涯苦作舟");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
