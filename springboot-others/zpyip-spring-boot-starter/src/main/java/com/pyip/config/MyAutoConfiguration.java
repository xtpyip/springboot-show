package com.pyip.config;

import com.pyip.pojo.SimpleBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: MyAutoConfiguration
 * @version: 1.0
 * @Author: pyipXt
 * @Description: 自定义配置类
 **/
@Configuration
@ConditionalOnClass
public class MyAutoConfiguration {

    @Bean
    public SimpleBean simpleBean(){
        return new SimpleBean();
    }
}
