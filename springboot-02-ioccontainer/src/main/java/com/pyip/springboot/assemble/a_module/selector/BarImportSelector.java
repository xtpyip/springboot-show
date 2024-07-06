package com.pyip.springboot.assemble.a_module.selector;

import com.pyip.springboot.assemble.a_module.component.Bar;
import com.pyip.springboot.assemble.a_module.config.BarConfiguration;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @ClassName: BarImportSelector
 * @version: 1.0
 * @Author: pyipXt
 * @Description: ImportSelector实现类
 **/
public class BarImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        System.out.println("BarImportSelector invoke ......");
        return new String[]{Bar.class.getName(), BarConfiguration.class.getName()};
    }
}