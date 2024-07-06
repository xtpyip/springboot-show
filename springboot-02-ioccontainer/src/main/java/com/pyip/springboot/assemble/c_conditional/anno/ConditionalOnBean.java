package com.pyip.springboot.assemble.c_conditional.anno;


import com.pyip.springboot.assemble.c_conditional.condition.OnBeanCondition;
import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Conditional(OnBeanCondition.class)
public @interface ConditionalOnBean {
    Class<?>[] value() default {};
    String[] beanNames() default {};
}
