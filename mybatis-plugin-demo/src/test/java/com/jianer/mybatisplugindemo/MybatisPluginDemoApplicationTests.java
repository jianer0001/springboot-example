package com.jianer.mybatisplugindemo;

import com.jianer.mybatisplugindemo.entity.Account;
import com.jianer.mybatisplugindemo.service.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybatisPluginDemoApplicationTests {

    @Autowired
    AccountService accountService;

    @Test
    void contextLoads() {
        Account account = new Account();
        account.setUid(49);
        account.setMoney(5221.0);
        accountService.insert(account);
        System.out.println(account.getId());
    }

}
