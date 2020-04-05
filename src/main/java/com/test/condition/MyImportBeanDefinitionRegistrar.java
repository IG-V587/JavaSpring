package com.test.condition;

import com.test.entity.Teacher;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {


    /**
     *
     * @param importingClassMetadata    这是当前类的注解信息
     * @param registry  注册类
     *                  把所有需要添加到容器中的bean：
     *                  通过 registry.registerBeanDefinition  手动注册进来
     *
     *
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        // 逻辑判断为： 如果存在student类，则生成一个teacher类 并且类名可以自定义
        boolean student = registry.containsBeanDefinition("com.test.entity.Student");
//        boolean teacher = registry.containsBeanDefinition("teacher");
        if (student){
            // 指定 bean 类名
            RootBeanDefinition rootBeanDefinition=new RootBeanDefinition(Teacher.class);
            registry.registerBeanDefinition("teacherHHH",rootBeanDefinition);
        }



    }
}
