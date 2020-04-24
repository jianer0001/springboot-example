package com.jianer.springbootmail.component;

import com.jianer.springbootmail.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author 杨兴健
 * @Date 2020/4/24 15:57
 */
@Component
public class MailTask {

    @Autowired
    MailService mailService;

    @Scheduled(cron = "5/5 * * * * ?")
    public void sendEmail(){
        mailService.sandSimpleMail();
    }
}
