package com.test.config;

import com.test.entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * className:MainConfig2
 * package:com.test.config
 * Description:
 *
 * @Date:2020/4/418:05
 * @Author:LiangGuang
 */
@Configuration
public class MainConfig2 {

    // 默认为单实例

    /**
     *  prototype :多实例的 ioc容器启动时并不会调用方法创建对象
     *              每次获取的时候 才会调用方法创建对象
     *  singleton: 单实例 (默认值) 在ioc容器启动时，调用方法创建对象放到ioc容器中
     *              以后每次获取都是从ioc中拿取  （map.get()）
     *  ---- web
     *  request: 同一次请求创建一个实例
     *  session:同一个session创建一个实例
     * @return
     */
    @Scope("singleton")
    @Bean
    public Person person(){
        return new Person("张三",22);
    }
}
