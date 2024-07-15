package com.pyip.springboot01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: MyConfig
 * @version: 1.0
 * @Author: pyipXt
 * @Description: 配置类
 **/
@Configuration
public class MyConfig {

    @Bean(name = "iService")
    public MyService myService(){
        return new MyService();
    }
}
