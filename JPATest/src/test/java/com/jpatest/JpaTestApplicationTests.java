package com.jpatest;

import com.jpatest.Repository.AccountRepository;
import com.jpatest.entity.Account;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class JpaTestApplicationTests {
    @Resource
    AccountRepository repository;

    @Test
    void contextLoads() {
        //直接根据ID查找
        repository.findById(1).ifPresent(System.out::println);
    }

    @Test
    void addAccount(){
        Account account = new Account();
        account.setUsername("Admin");
        account.setPassword("123456");
        account = repository.save(account);  //返回的结果会包含自动生成的主键值
        System.out.println("插入时，自动生成的主键ID为："+account.getId());
    }

}
