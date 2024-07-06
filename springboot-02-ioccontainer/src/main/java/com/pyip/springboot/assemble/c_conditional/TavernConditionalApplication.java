package com.pyip.springboot.assemble.c_conditional;

import com.pyip.springboot.assemble.c_conditional.config.TavernConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.Stream;

/**
 * @ClassName: TavernApplication
 * @version: 1.0
 * @Author: pyipXt
 * @Description: 启动测试类
 **/

public class TavernConditionalApplication {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(TavernConfiguration.class);
        Stream.of(ctx.getBeanDefinitionNames()).forEach(System.out::println);
    }
}
