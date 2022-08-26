package com.test4.controller;


import com.test4.service.RedisService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("redis")
public class RedisController {
    @Autowired
    RedisService2 redisService2;

    /**
     * description hello world！
     * return java.lang.String
     * author 郑晓龙
     * createTime 2019/12/12 16:36
     **/
    @GetMapping("hello")
    public String hello() {
        return "hello,SpringBoot!";
    }

    /**
     * description 不带事务set
     * return java.lang.String
     * author 郑晓龙
     * createTime 2019/12/12 16:36
     **/
    @GetMapping("put")
    public void put(String key, String value) {
        redisService2.put(key, value);
    }

    /**
     * description 带事务set
     * return java.lang.String
     * author 郑晓龙
     * createTime 2019/12/12 16:36
     **/
    @GetMapping("putWithTx")
    public void putWithTx(String key, String value) {
        redisService2.putWithTx(key, value);
    }

    /**
     * description 调用带事务方法不生效的情况
     * return java.lang.String
     * author 郑晓龙
     * createTime 2019/12/12 16:36
     **/
    @GetMapping("invokeWithPutTx")
    public void invokeWithPutTx(String key, String value) {
        redisService2.invokePutWithTx(key, value);
    }

    /**
     * description 调用带事务方法生效的情况
     * return java.lang.String
     * author 郑晓龙
     * createTime 2019/12/12 16:36
     **/
    @GetMapping("invokeWithPutTx2")
    public void invokeWithPutTx2(String key, String value) {
        redisService2.invokePutWithTx2(key, value);
    }
}