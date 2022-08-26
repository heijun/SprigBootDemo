package com.test4.service;

import lombok.Data;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

@Service
public class RedisService  {

    @Resource
    private StringRedisTemplate stringRedisTemplate;


    public void testSessionCallback(){
        StringRedisTemplate  stringRedisTemplate = this.getRedisTemplate();

        testSessionCallback( stringRedisTemplate);
    }

    private StringRedisTemplate getRedisTemplate() {
        return  stringRedisTemplate;
    }


    public void testSessionCallback(StringRedisTemplate  stringRedisTemplate) {
        stringRedisTemplate.execute(new SessionCallback() {
            @Override
            public Object execute(RedisOperations redisOperations) throws DataAccessException {
               /* redisOperations.opsForValue().set("myKey", value);*/
                String myValue = String.valueOf(redisOperations.opsForValue().get("b"));
                System.out.println(myValue);
                return myValue;
            }
        });
    }

}