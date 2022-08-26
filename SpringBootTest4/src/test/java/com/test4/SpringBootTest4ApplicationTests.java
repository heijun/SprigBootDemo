package com.test4;

import com.test4.service.RedisService;
import com.test4.service.RedisService2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
class SpringBootTest4ApplicationTests {
    @Autowired
    RedisService service;

    @Autowired
    RedisService2 service2;

    @Test
    void contextLoads() {
    /*    service.testSessionCallback();*/
        service2.put("c","jjj");
        //记得clear
    }
}
