package com.pyip.springboot.assemble.b_profile;

import com.pyip.springboot.assemble.b_profile.config.TavernConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.Stream;

/**
 * @ClassName: TavernApplication
 * @version: 1.0
 * @Author: pyipXt
 * @Description: 启动测试类
 **/

public class TavernProfileApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(TavernConfiguration.class);
//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
//        ctx.getEnvironment().setActiveProfiles("city");
//        ctx.register(TavernConfiguration.class);
//        ctx.refresh();
        Stream.of(ctx.getBeanDefinitionNames()).forEach(System.out::println);
        System.out.println("--------------------------");
    }
}
