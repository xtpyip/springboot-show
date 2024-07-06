package com.pyip.springboot.quickstart.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: HelloController
 * @version: 1.0
 * @Author: pyipXt
 * @Description: 接口测试
 **/
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "hello springboot";
    }
}
