package com.pyip.springboot.assemble.c_conditional.condition;

import com.pyip.springboot.assemble.c_conditional.anno.ConditionalOnBean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

/**
 * @ClassName: OnBeanCondition
 * @version: 1.0
 * @Author: pyipXt
 * @Description:
 **/
public class OnBeanCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Map<String, Object> attributes = metadata.getAnnotationAttributes(ConditionalOnBean.class.getName());
        // 匹配类型
        Class<?>[] classes = (Class<?>[]) attributes.get("value");
        for (Class<?> clazz : classes) {
            if (!context.getBeanFactory().containsBeanDefinition(clazz.getName())) {
                return false;
            }
        }
        // 匹配beanName
        String[] beanNames = (String[]) attributes.get("beanNames");
        for (String beanName : beanNames) {
            if (!context.getBeanFactory().containsBeanDefinition(beanName)) {
                return false;
            }
        }
        return true;
    }
}
