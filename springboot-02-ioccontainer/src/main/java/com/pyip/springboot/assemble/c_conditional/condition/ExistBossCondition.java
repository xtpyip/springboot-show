package com.pyip.springboot.assemble.c_conditional.condition;

import com.pyip.springboot.assemble.c_conditional.component.Boss;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @ClassName: ExistBossCondition
 * @version: 1.0
 * @Author: pyipXt
 * @Description: 存在Boss类则满足条件
 **/
public class ExistBossCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return context.getBeanFactory().containsBeanDefinition(Boss.class.getName());
    }
}
