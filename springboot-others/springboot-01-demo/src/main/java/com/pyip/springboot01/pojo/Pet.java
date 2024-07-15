package com.pyip.springboot01.pojo;

/**
 * @ClassName: Pet
 * @version: 1.0
 * @Author: pyipXt
 * @Description: 宠物实体类
 **/
public class Pet {
    private String type;
    private String name;

    public Pet(String type, String name) {
        this.type = type;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public Pet() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
