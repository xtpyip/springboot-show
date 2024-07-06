package com.pyip.springboot.assemble.b_profile.config;

import com.pyip.springboot.assemble.b_profile.component.Bar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: BarConfiguration
 * @version: 1.0
 * @Author: pyipXt
 * @Description: 吧台配置类
 **/
@Configuration
public class BarConfiguration {
    @Bean
    public Bar bbbar() {
        return new Bar();
    }
}
