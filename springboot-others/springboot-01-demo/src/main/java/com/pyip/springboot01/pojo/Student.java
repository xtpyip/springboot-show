package com.pyip.springboot01.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @ClassName: Student
 * @version: 1.0
 * @Author: pyipXt
 * @Description: Student类
 **/
@Component
public class Student {
    @Value("3")
    private int id;

    @Value("${person.name}")
    private String name;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
