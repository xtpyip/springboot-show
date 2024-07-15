package com.pyip.springboot01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: HelloController
 * @version: 1.0
 * @Author: pyipXt
 * @Description: 接口
 **/
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String sayHello(){

        return "Hello Spring Boot\n1";
    }
}
