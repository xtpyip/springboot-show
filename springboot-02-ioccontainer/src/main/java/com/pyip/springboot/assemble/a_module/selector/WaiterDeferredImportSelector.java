package com.pyip.springboot.assemble.a_module.selector;

import com.pyip.springboot.assemble.a_module.component.Waiter;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @ClassName: WaiterDeferredImportSelector
 * @version: 1.0
 * @Author: pyipXt
 * @Description: ImportSelector的子接口实现类
 **/
public class WaiterDeferredImportSelector implements DeferredImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        System.out.println("WaiterDeferredImportSelector invoke ...");
        return new String[]{Waiter.class.getName()};
    }
}
