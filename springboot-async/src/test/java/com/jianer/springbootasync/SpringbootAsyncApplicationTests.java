package com.jianer.springbootasync;

import com.jianer.springbootasync.service.AsyncService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest()
@RunWith(SpringRunner.class)
class SpringbootAsyncApplicationTests {

    @Autowired
    AsyncService asyncService;
    @Test
    void contextLoads()  {
        for (int i = 0;i <1000;i++) {
            asyncService.show2();
        }

//        asyncService.show(0);

    }

}
