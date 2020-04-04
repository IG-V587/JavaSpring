package com.test.MainTest;

import com.test.config.MainConfig;
import com.test.entity.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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


}
