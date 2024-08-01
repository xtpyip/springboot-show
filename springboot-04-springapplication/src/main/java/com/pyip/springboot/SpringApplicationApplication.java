package com.pyip.springboot;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;

/**
 * @ClassName: SpringApplicationApplication
 * @version: 1.0
 * @Author: pyipXt
 * @Description: 启动方式
 **/
@SpringBootApplication
public class SpringApplicationApplication {
    public static void main(String[] args) {
        // 方式一：直接操作SpringApplication的api
//        SpringApplication springApplication = new SpringApplication();
//        springApplication.setMainApplicationClass(SpringApplicationApplication.class);
        // 这样些会报错：java.lang.IllegalArgumentException: Sources must not be empty （可能是版本原因，2.3.11 没有看到SpringApplication这个类的无参构造器）
//        SpringApplication springApplication = new SpringApplication(SpringApplicationApplication.class);
////        SpringApplication springApplication = new SpringApplication();
////        springApplication.setMainApplicationClass(SpringApplicationApplication.class);
//        springApplication.setWebApplicationType(WebApplicationType.SERVLET);
//        springApplication.setBannerMode(Banner.Mode.OFF); // 关闭Banner打印
////        springApplication.addListeners(new ApplicationStartingEvent()); 必须要两个参数
//        springApplication.run(args);

//        // 方式二：借助构建器
//         SpringApplicationApplication类上一定要加注解@SpringBootApplication
//         否则报org.springframework.context.ApplicationContextException Unable to start ServletWebServerApplicationContext due to missing ServletWebServerFactory bean.
        new SpringApplicationBuilder(SpringApplicationApplication.class)
                .bannerMode(Banner.Mode.CONSOLE)
                .web(WebApplicationType.SERVLET) // 指定web应用类型为非WEB
//                .listeners(new ApplicationStartingEvent()) // 必须指定两个参数
                .run(args);
    }

}

/* 在spring.factories中添加
org.springframework.context.ApplicationListener=\
        com.pyip.springboot.listener.ApplicationStartingListener

*/

//@SpringBootApplication
//public class SpringApplicationApplication {
//    public static void main(String[] args) {
//        SpringApplication.run(SpringApplicationApplication.class,args);
//    }
//}

