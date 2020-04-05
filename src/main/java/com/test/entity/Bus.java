package com.test.entity;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class Bus implements InitializingBean, DisposableBean {


    public Bus() {
        System.out.println("bus构造方法");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("bus 销毁方法");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("bus 初始化方法");
    }
}
