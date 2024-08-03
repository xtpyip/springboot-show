package com.pyip.springboot;

import com.pyip.springboot.service.DemoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @ClassName: SpringBootAopApplication
 * @version: 1.0
 * @Author: pyipXt
 * @Description: 主启动类
 **/
@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringBootAopApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringBootAopApplication.class, args);
        ctx.getBean(DemoService.class).save();
    }

}
