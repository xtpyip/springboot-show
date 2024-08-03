package com.pyip.springboot.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @ClassName: ServiceAspect
 * @version: 1.0
 * @Author: pyipXt
 * @Description: 切面方法
 **/
@Aspect
@Component
public class ServiceAspect {

    @Before("execution(public * com.pyip.springboot.service.*.*(..))")
    public void before(){
        System.out.println("service aspect before");
    }
}
