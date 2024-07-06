package com.pyip.springboot.assemble.d_spi;

import com.pyip.springboot.assemble.d_spi.bean.DemoDao;
import org.springframework.core.io.support.SpringFactoriesLoader;

import java.util.List;

/**
 * @ClassName: SpringSpiApplication
 * @version: 1.0
 * @Author: pyipXt
 * @Description: spring3.2的Spi
 **/
public class SpringSpiApplication {
    public static void main(String[] args) {
        List<DemoDao> demoDaos = SpringFactoriesLoader.loadFactories(
                DemoDao.class, SpringSpiApplication.class.getClassLoader());
        demoDaos.forEach(dao ->{
            System.out.println(dao);
        });
        System.out.println("-----------------------------");
        List<String> daoClassNames = SpringFactoriesLoader.loadFactoryNames(DemoDao.class, SpringSpiApplication.class.getClassLoader());
        daoClassNames.forEach(className ->{
            System.out.println(className);
        });
    }
}
