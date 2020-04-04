package com.test.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * className:LinuxConditon
 * package:com.test.condition
 * Description: 判断是否为linux系统
 *
 * @Date:2020/4/418:50
 * @Author:LiangGuang
 */
public class LinuxConditon implements Condition {
    /**
     *
     * @param conditionContext  判断条件能使用的上下文环境
     * @param annotatedTypeMetadata 注释信息
     * @return
     */
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {

        // 判断是否linux系统
        // 1、能获取到ioc使用的beanFactory
        ConfigurableListableBeanFactory beanFactory = conditionContext.getBeanFactory();
        // 2、类加载器
        ClassLoader classLoader = conditionContext.getClassLoader();
        // 3、获取当前环境信息
        Environment environment = conditionContext.getEnvironment();
        // 4、获取到bean定义的注册类
        BeanDefinitionRegistry registry = conditionContext.getRegistry();


        String property = environment.getProperty("os.name");
        if(property.contains("linux")){return true;}

        return false;
    }
}
