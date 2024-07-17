package com.pyip.demo04.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName: MyConfig
 * @version: 1.0
 * @Author: pyipXt
 * @Description: 配置类
 **/
@Configuration
public class MyConfig implements WebMvcConfigurer {

    //自定义国际化主键就生效了
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocalResolver();
    }
}
