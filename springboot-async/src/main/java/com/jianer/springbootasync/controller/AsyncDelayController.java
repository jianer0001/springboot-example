package com.jianer.springbootasync.controller;

import com.jianer.springbootasync.service.AsyncDelayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 杨兴健
 * @Date 2020/4/23 14:44
 */
@RestController
public class AsyncDelayController {
    private static final Logger log = LoggerFactory.getLogger(AsyncDelayController.class);

    @Autowired
    AsyncDelayService asyncDelayService;

    @GetMapping("/delay")
    public String delayController() {
        long timeMillis = System.currentTimeMillis();
        log.info("处理业务中");
        long time = System.currentTimeMillis() - timeMillis;
        asyncDelayService.delay();
        return "处理业务总时间为" + time + "毫秒";
    }
}
