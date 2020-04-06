package com.test.entity;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

@Component
public class Red implements ApplicationContextAware, BeanFactoryAware, EmbeddedValueResolverAware, BeanNameAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("-----传入的ioc容器："+applicationContext);
        this.applicationContext=applicationContext;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
//        System.out.println("beanFactory:"+beanFactory);
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {
        System.out.println("解析");
        String stringValue = stringValueResolver.resolveStringValue("你好啊${os.name},and = #{30-2}");
        System.out.println(stringValue);

    }

    @Override
    public void setBeanName(String s) {
        System.out.println("传入的名字："+s);
    }
}
