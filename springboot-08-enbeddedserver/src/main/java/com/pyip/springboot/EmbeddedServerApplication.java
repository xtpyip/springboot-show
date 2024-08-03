package com.pyip.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName: SpringBootLifecycleApplication
 * @version: 1.0
 * @Author: pyipXt
 * @Description: 启动类
 **/
@SpringBootApplication
public class EmbeddedServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmbeddedServerApplication.class, args);
    }
}