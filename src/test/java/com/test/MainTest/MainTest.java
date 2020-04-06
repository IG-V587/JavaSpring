package com.test.MainTest;

import com.test.config.*;
import com.test.dao.BookDao;
import com.test.entity.Person;
import com.test.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import javax.sql.DataSource;

/**
 * className:MainTest
 * package:com.test.MainTest
 * Description:
 *
 * @Date:2020/4/416:25
 * @Author:LiangGuang
 */

public class MainTest {

    @Test
    public void test01(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("beans.xml");

        Person p= (Person) applicationContext.getBean("person");
        System.out.println(p);

    }

    @Test
    public void test02(){
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(MainConfig.class);
        Person person= (Person) applicationContext.getBean("person");
        System.out.println(person);

        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
        for (String name:beanNamesForType) {
            System.out.println(name);
        }
    }

    @Test
    public void test03(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for(String name:definitionNames){
            System.out.println(name);
        }
    }


    @Test
    public void test04(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for(String name:definitionNames){
            System.out.println(name);
        }

        // 默认为单实例
        Person person= (Person) applicationContext.getBean("person");
        Person person2= (Person) applicationContext.getBean("person");
        System.out.println(person==person2);

    }

    @Test
    public void test05(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig2.class);
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for(String name:definitionNames){
            System.out.println(name);
        }
        // 工厂bean 获取的是调用 getObject 创建对象
        Object bean = applicationContext.getBean("studentFacoroyBean");
        Object bean2 = applicationContext.getBean("studentFacoroyBean");
        Object bean3 = applicationContext.getBean("&studentFacoroyBean");
        System.out.println(bean);
        System.out.println(bean==bean2);
        System.out.println(bean3);

    }

    @Test
    public void test06(){
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        applicationContext.close();

    }

    @Test
    public void test07(){
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(MainConfigOfProperty.class);
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for(String name:definitionNames){
            System.out.println(name);
        }
        Person person=applicationContext.getBean(Person.class);
        System.out.println(person);
        ConfigurableEnvironment environment =applicationContext.getEnvironment();
        String property = environment.getProperty("person.nickName");
        System.out.println(property);

    }

    @Test
    public void test08(){
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for(String name:definitionNames){
            System.out.println(name);
        }
        BookService bean = applicationContext.getBean(BookService.class);
        BookDao bean1 = applicationContext.getBean(BookDao.class);
        System.out.println(bean);
        System.out.println(bean1);
    }

    @Test
    public void test09(){
        // 1. 使用命令行动态参数，在虚拟机参数位置加载  -Dspring.profiles.active=test           指定某个环境生效
        // 2. 代码激活某个环境

//        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(MainConfigOfProfile.class);
        // 1、创建一个applicationContext
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext();
        // 2、设置需要激活的环境
        applicationContext.getEnvironment().setActiveProfiles("test","dev");
        // 3、注册主配置类
        applicationContext.register(MainConfigOfProfile.class);
        // 4、启动刷新容器
        applicationContext.refresh();
        String[] namesForType = applicationContext.getBeanNamesForType(DataSource.class);
        for(String name:namesForType){
            System.out.println(name);
        }

    }
}
