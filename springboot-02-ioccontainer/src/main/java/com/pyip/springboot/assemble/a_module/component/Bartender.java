package com.pyip.springboot.assemble.a_module.component;

/**
 * @ClassName: Bartender
 * @version: 1.0
 * @Author: pyipXt
 * @Description: 调酒师
 **/
public class Bartender {
    private String name;
    public Bartender(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
