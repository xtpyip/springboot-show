package com.pyip.springboot01;

import com.pyip.springboot01.config.MyService;
import com.pyip.springboot01.controller.HelloController;
import com.pyip.springboot01.pojo.MyProperties;
import com.pyip.springboot01.pojo.Person;
import com.pyip.springboot01.pojo.Student;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName: SpringBootDemoTest
 * @version: 1.0
 * @Author: pyipXt
 * @Description: 测试类
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringBootDemoTest {
    @Autowired
    private HelloController helloController;

    @Autowired
    private Person person;

    @Autowired
    private Student student;
    @Autowired
    private MyProperties myProperties;

    @Autowired
    private MyService myService;

    @Test
    public void test01(){
        String result = helloController.sayHello();
        System.out.println(result);// Hello Spring Boot
    }

    @Test
    public void test02(){
        // Person{id=1, name='tom', hobby=[??, ??, ???], family=[father, mother], map={k1=v1, k2=v2}, pet=Pet{type='dog', name='??'}}
        System.out.println(person.toString());
    }
    @Test
    public void test03(){
        // Student{id=3, name='tom'}
        System.out.println(student.toString());
    }

    @Test
    public void test04(){
        // MyProperties{id=110, name='test'}
        System.out.println(myProperties);
    }


    @Test
    public void test05(){
        // com.pyip.springboot01.config.MyService@776802b0
        System.out.println(myService);
    }
    @Autowired
    private ApplicationContext context;
    @Test
    public void test06(){
        // true
        System.out.println(context.containsBean("iService"));
    }

    @Value("${tom.description}")
    private String description;
    @Test
    public void test07(){
        // tom的年龄可能是15
        System.out.println(description);
    }
}
