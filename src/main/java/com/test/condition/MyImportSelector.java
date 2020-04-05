package com.test.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Set;

// 自定义逻辑 返回需要导入的组件
public class MyImportSelector implements ImportSelector {

    /**
     * 返回值就是导入到容器中的组件全类名
     * @param annotationMetadata    当前标注@Import注解的类的所有注解信息
     * @return
     */
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        //annotationMetadata 可以获取到 注解类的所有信息 ，也可以获取到类的信息
        // 通过逻辑判断等方式 拿到所需要 生成的bean

        String className = annotationMetadata.getClassName();
        System.out.println("---------------"+className); // com.test.config.MainConfig2
        Set<String> annotationTypes = annotationMetadata.getAnnotationTypes();
        System.out.println(annotationTypes);// [org.springframework.context.annotation.Configuration, org.springframework.context.annotation.Import]

        return new String[]{"com.test.entity.Teacher"};
    }
}
