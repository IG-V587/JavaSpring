package com.test.config;


import com.test.entity.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * bean 的生命周期
 *         创建 ---> 初始化  --->  销毁
 *容器管理bean的生命周期
 * 我们可以自定义初始化和销毁方法，容器在bean进行到当前生命周期的时候来调用我们自定义的初始化和销毁
 *  1、指定初始化和销毁方法
 *      指定 innt-method  destroy-method
 *  2、通过让bean实现 InitializingBean (定义初始化逻辑)
 *                   DisposableBean(定义销毁逻辑)
 *  3、可以使用JSR250:
 * @PostConstrust: 在bean 创建完成并且属性赋值完成，进行初始化方法
 * @PreDestroy: 在容器销毁bean之前通知我们进行清理工作
 *
 * 构造（对象创建）
 *      单实例：在容器启动的时候创建对象
 *      多实例：在每次获取的时候创建对象
 *  初始化：
 *      对象创建完成，并赋值好，调用初始化方法
 *  销毁：
 *      单例：容器关闭的时候进行销毁
 *      多例：容器不会管理这个bean，容器不会调用销毁方法
 */
@ComponentScan("com.test.entity")
@Configuration
public class MainConfigOfLifeCycle {

    @Bean(initMethod = "init",destroyMethod = "destory")
    public Car car(){
        return new Car();
    }

}
