package com.pyip.springboot;

import com.pyip.springboot.service.UserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @ClassName: MybatisSpringBootApplication
 * @version: 1.0
 * @Author: pyipXt
 * @Description: TODO
 **/
@SpringBootApplication
@EnableTransactionManagement
@MapperScan
public class MyBatisSpringBootApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(MyBatisSpringBootApplication.class, args);
        UserService userService = ctx.getBean(UserService.class);
        userService.test();
    }
}

