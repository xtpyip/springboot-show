package com.pyip.springboot.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @ClassName: ApplicationStartingListener
 * @version: 1.0
 * @Author: pyipXt
 * @Description: 自定义应用事件监听器
 **/
//org.springframework.context.ApplicationListener
public class ApplicationStartingListener implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        System.out.println("1. 应用开始监听----" + applicationEvent.toString());
    }
}
