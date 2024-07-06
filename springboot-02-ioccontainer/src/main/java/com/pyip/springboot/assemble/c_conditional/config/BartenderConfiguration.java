package com.pyip.springboot.assemble.c_conditional.config;

import com.pyip.springboot.assemble.c_conditional.component.Bartender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @ClassName: BartenderConfiguration
 * @version: 1.0
 * @Author: pyipXt
 * @Description: 调酒师配置类
 **/
@Configuration
@Profile("city")
public class BartenderConfiguration {
    @Bean
    public Bartender zhangxiaosan(){
        return new Bartender("张小三");
    }

    @Bean
    public Bartender zhangdasan(){
        return new Bartender("张大三");
    }
}
