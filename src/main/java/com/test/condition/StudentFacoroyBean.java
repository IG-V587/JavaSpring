package com.test.condition;

import com.test.entity.Student;
import org.springframework.beans.factory.FactoryBean;

public class StudentFacoroyBean implements FactoryBean<Student> {
    @Override
    public Student getObject() throws Exception {
        System.out.println("调用getObject方法了");
        return new Student();
    }

    @Override
    public Class<?> getObjectType() {
        return Student.class;
    }

    // 控制 是否单例  true  单例  false  多例模式
    @Override
    public boolean isSingleton() {
        return true;
    }
}
