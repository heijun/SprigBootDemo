package com.test4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class RedisService2 {
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    RedisService2 redisService2;
    /**
     * description 不带事务写入
     **/
    public void put(String key,String value){
        stringRedisTemplate.opsForValue().set(key,value);
    }
    /**
     * description 带事务写入
     **/
    @Transactional(rollbackFor = Throwable.class)
    public void putWithTx(String key,String value){
        stringRedisTemplate.opsForValue().set(key,value);
    }
    /**
     * description 该方法演示内部调用带事务方法 事务不生效的情况
     **/
    public void invokePutWithTx(String key,String value){
        putWithTx(key,value);
    }
    /**
     * description 该方法演示内部调用带事务方法 事务生效的情况
     **/
    public void invokePutWithTx2(String key,String value){
        redisService2.putWithTx(key,value);
    }

}