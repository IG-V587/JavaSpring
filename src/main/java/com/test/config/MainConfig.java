package com.test.config;

import com.test.entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * className:MainConfig
 * package:com.test.config
 * Description: 配置类==配置文件
 *
 * @Date:2020/4/416:42
 * @Author:LiangGuang
 */
@Configuration // 告诉spring 这是一个配置类
public class MainConfig {
    // 给容器中注册一个bean 类型为返回值的类型 id 默认是方法名
    // 修改方法名 或者 @Bean("") bean注解中写入值 修改 id
    @Bean
    public Person person(){
        return new Person("李四",20);
    }
}
