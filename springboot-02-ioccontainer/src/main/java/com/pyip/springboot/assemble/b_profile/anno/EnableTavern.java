package com.pyip.springboot.assemble.b_profile.anno;

import com.pyip.springboot.assemble.b_profile.component.Boss;
import com.pyip.springboot.assemble.b_profile.config.BartenderConfiguration;
import com.pyip.springboot.assemble.b_profile.registrar.WaiterRegistrar;
import com.pyip.springboot.assemble.b_profile.selector.BarImportSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @ClassName: EnableTavern
 * @version: 1.0
 * @Author: pyipXt
 * @Description: 声明自定义注解
 **/
// 如果一个注解@B，被@Documented标注，那么被@B修饰的类，生成文档时，会显示@B。
// 如果@B没有被@Documented标注，最终生成的文档中就不会显示@B。这里的生成文档指的JavaDoc文档！javadoc.exe
@Documented // @Documented只能用在注解上，
@Retention(RetentionPolicy.RUNTIME) // 表示注解将在运行时保留，允许通过反射获取注解信息。
@Target(ElementType.TYPE) // 该注解只能作用于类上 指定被修饰的Annotation可以放置的位置(被修饰的目标)
@Import({Boss.class, BartenderConfiguration.class, BarImportSelector.class, WaiterRegistrar.class})
public @interface EnableTavern {
}
