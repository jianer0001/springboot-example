package com.jianer.springbootasync.service.impl;

import com.jianer.springbootasync.bo.MyDelayed;
import com.jianer.springbootasync.service.AsyncDelayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.DelayQueue;

/**
 * @author 杨兴健
 * @Date 2020/4/23 14:51
 */
@Service
public class AsyncDelayServiceImpl implements AsyncDelayService {
    private static final Logger log = LoggerFactory.getLogger(AsyncDelayServiceImpl.class);

    @Override
    @Async("myExecutor")
    public void delay()  {
        long millis = System.currentTimeMillis();
        log.info("----------开始延迟队列-------------");
        String time = DateFormat.getDateTimeInstance().format(new Date());
        log.info("开始时间：{}",time);
        DelayQueue<MyDelayed> delayQueue = new DelayQueue<>();
        int[] times = {5,10,15};
        for (int i : times) {
            delayQueue.put(new MyDelayed(i*1000));
        }

        while (!delayQueue.isEmpty()) {
            log.info("====开始延迟发消息====");
            String format = DateFormat.getDateTimeInstance().format(new Date());
            log.info("开始时间为:{}",format);
            boolean send = send();
            if(send) {
                log.info("已发送成功，停止发送!!!");
                long l = (System.currentTimeMillis() - millis) ;
                log.info("发送消息总用时:{}",l);
                return;
            }
            log.info("发送失败，继续尝试发送>>>");
            try {
                MyDelayed myDelayed = delayQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        log.info("尝试已完成，结果发送失败!!!");
        long l = (System.currentTimeMillis() - millis) ;
        log.info("发送消息总用时:{}",l);
    }

    private boolean send() {
        log.info("模拟发消息中>>>>>");
        int nextInt = new Random().nextInt(12);
        log.info("random:{}",nextInt);
        return nextInt / 3 == 0;
    }
}
