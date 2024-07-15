package com.pyip.springboot.beandefinition.config;

import com.pyip.springboot.beandefinition.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanDefinitionConfiguration {
    
    @Bean
    public Person person() {
        return new Person();
    }
}
