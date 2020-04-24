package com.jianer.springbootmail;

import com.jianer.springbootmail.service.MailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootMailApplicationTests {

    @Autowired
    MailService mailService;

    @Test
    void contextLoads() {
        mailService.sandSimpleMail();
    }

}
