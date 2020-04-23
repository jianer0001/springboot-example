package com.jianer.springbootasync.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author 杨兴健
 * @Date 2020/4/22 22:02
 */
@Configuration
public class AsyncConfig {
    // 当池子大小小于corePoolSize，就新建线程，并处理请求
    // 当池子大小等于corePoolSize，把请求放入workQueue(QueueCapacity)中，池子里的空闲线程就去workQueue中取任务并处理
    // 当workQueue放不下任务时，就新建线程入池，并处理请求，如果池子大小撑到了maximumPoolSize，就用RejectedExecutionHandler来做拒绝处理
    // 当池子的线程数大于corePoolSize时，多余的线程会等待keepAliveTime长时间，如果无请求可处理就自行销毁

    @Bean("myExecutor")
    public Executor executor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(30);
        executor.setKeepAliveSeconds(60);
        executor.setQueueCapacity(15);
        executor.setThreadNamePrefix("async-");
        /*
          当线程池的任务缓冲队列已经满，并且线程池中的线程数目已达到maximumPoolSize,如果还有任务到来就会采取任务拒绝策略
          通常有四种策略
          ThreadPoolExecutor.AbortPolicy():丢弃任务并抛出RejectedExecutionException异常
          ThreadPoolExecutor.DiscardPolicy():也是丢弃，但是不抛异常
          ThreadPoolExecutor.DiscardOldestPolicy():丢弃最早的任务，然后重新执行任务（重复此过程）
          ThreadPoolExecutor.CallerRunsPolicy():重试添加当前任务，自动重复调用execute()方法，直到成功
         */
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //初始化线程
        executor.initialize();
        return executor;
    }


}
