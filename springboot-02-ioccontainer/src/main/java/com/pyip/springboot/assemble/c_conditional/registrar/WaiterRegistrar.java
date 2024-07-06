package com.pyip.springboot.assemble.c_conditional.registrar;

import com.pyip.springboot.assemble.c_conditional.component.Waiter;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @ClassName: WaiterRegistrar
 * @version: 1.0
 * @Author: pyipXt
 * @Description: 服务员注册类
 **/
public class WaiterRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata metadata, BeanDefinitionRegistry registry){
        System.out.println("WaiterRegistrar invoke...");
        registry.registerBeanDefinition("waiter",new RootBeanDefinition(Waiter.class));
    }
}
