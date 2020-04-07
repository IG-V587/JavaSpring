package com.test.MainTest;

import com.test.aop.MathCaluator;
import com.test.config.MainConfigOfAOP;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test_AOP {

    @Test
    public void test01(){
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(MainConfigOfAOP.class);
        MathCaluator mathCaluator = applicationContext.getBean(MathCaluator.class);
        mathCaluator.div(1,0);

    }
}
