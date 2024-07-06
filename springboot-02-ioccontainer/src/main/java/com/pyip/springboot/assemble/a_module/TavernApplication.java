package com.pyip.springboot.assemble.a_module;

import com.pyip.springboot.assemble.a_module.anno.EnableTavern;
import com.pyip.springboot.assemble.a_module.component.Bartender;
import com.pyip.springboot.assemble.a_module.component.Boss;
import com.pyip.springboot.assemble.a_module.config.TavernConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.stream.Stream;

/**
 * @ClassName: TavernApplication
 * @version: 1.0
 * @Author: pyipXt
 * @Description: 启动测试类
 **/

public class TavernApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(TavernConfiguration.class);
        Stream.of(ctx.getBeanDefinitionNames()).forEach(System.out::println);
        System.out.println("--------------------------");
//        Boss boss = ctx.getBean(Boss.class);
//        System.out.println(boss);
//        Map<String, Bartender> bartenders = ctx.getBeansOfType(Bartender.class);
//        bartenders.forEach((name,bartender)-> System.out.println(bartender));
    }
}
