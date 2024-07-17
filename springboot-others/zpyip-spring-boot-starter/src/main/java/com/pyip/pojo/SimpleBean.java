package com.pyip.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName: SimpleBean
 * @version: 1.0
 * @Author: pyipXt
 * @Description: 样例bean
 **/
//@EnableConfigurationProperties
//@ConfigurationProperties(prefix = "simplebean")

@ConfigurationProperties(prefix = "simplebean")
@Component
public class SimpleBean {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
