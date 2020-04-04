package com.test.MainTest;

import com.test.config.MainConfig;
import com.test.config.MainConfig2;
import com.test.entity.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sun.applet.Main;

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
    }
}
