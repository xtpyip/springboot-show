package com.pyip.springboot.assemble.d_spi;

import com.pyip.springboot.assemble.d_spi.bean.DemoDao;

import java.util.ServiceLoader;

/**
 * @ClassName: JdkSpiApplication
 * @version: 1.0
 * @Author: pyipXt
 * @Description: Jdk原生的spi
 **/
public class JdkSpiApplication {
    public static void main(String[] args) {
        ServiceLoader<DemoDao> serviceLoader = ServiceLoader.load(DemoDao.class);
        serviceLoader.iterator().forEachRemaining(dao ->{
            System.out.println(dao);
        });

    }
}
