package com.pyip.springboot;

import com.pyip.springboot.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @ClassName: SpringBootJdbcApplication
 * @version: 1.0
 * @Author: pyipXt
 * @Description: 启动类
 **/
@SpringBootApplication
@EnableTransactionManagement
public class SpringBootJdbcApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringBootJdbcApplication.class, args);
        UserService userService = ctx.getBean(UserService.class);

        userService.test();
    }
}
