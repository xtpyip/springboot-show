package com.pyip.springboot.assemble.c_conditional.config;

import com.pyip.springboot.assemble.c_conditional.component.Bar;
import com.pyip.springboot.assemble.c_conditional.component.Boss;
import com.pyip.springboot.assemble.c_conditional.anno.ConditionalOnBean;
import com.pyip.springboot.assemble.c_conditional.condition.ExistBossCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
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
    @Conditional(ExistBossCondition.class)
//    @ConditionalOnBean(Boss.class)
    public Bar bbbar() {
        return new Bar();
    }
}
