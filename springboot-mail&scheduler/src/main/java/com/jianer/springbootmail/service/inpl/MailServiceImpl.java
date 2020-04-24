package com.jianer.springbootmail.service.inpl;

import com.jianer.springbootmail.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author 杨兴健
 * @Date 2020/4/24 13:40
 */
@Service
public class MailServiceImpl implements MailService {

    @Value("${mail.from}")
    private String from;
    @Value("${mail.to}")
    private String to;

    @Autowired
    JavaMailSender mailSender;


    @Override
    public void sandSimpleMail() {
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setFrom(from);
        mailMessage.setTo(to);
        mailMessage.setText("简单邮件测试内容");
        mailMessage.setSubject("测试主题");
        mailMessage.setSentDate(new Date());

        mailSender.send(mailMessage);
    }
}
