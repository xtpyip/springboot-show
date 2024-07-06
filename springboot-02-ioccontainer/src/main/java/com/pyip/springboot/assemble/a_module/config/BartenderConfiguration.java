package com.pyip.springboot.assemble.a_module.config;

import com.pyip.springboot.assemble.a_module.component.Bartender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: BartenderConfiguration
 * @version: 1.0
 * @Author: pyipXt
 * @Description: 调酒师配置类
 **/
@Configuration
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
