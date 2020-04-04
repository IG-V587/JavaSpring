package com.test.config;

import com.test.entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * className:MainConfig
 * package:com.test.config
 * Description: 配置类==配置文件
 *
 * @Date:2020/4/416:42
 * @Author:LiangGuang
 */
@Configuration // 告诉spring 这是一个配置类
//@ComponentScan(value = "com.test",
//        excludeFilters = {
//            @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class, Service.class})// controller和Service注解不扫描
//        }
//)
//@ComponentScan(value = "com.test",
//        excludeFilters = {
//                @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Controller.class)// controller注解不扫描
//        }
//)

@ComponentScan(value = "com.test",
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class, Service.class})// controller和Service注解不扫描
        },useDefaultFilters = false
)
// ComponentScan value:指定要扫描的包
//excludeFilters=Filter[] 排除  （不扫描） type 可以根据注解，自定义，正则等等方式
// includeFilters=Filter[] 包含   指定扫描  这里必须禁用默认扫描规则（默认为全扫描） useDefaultFilters = false
// @ComponentScan 可以多次使用（java 8 以后） 也可以写在 @ComponentScans 中
public class MainConfig {
    // 给容器中注册一个bean 类型为返回值的类型 id 默认是方法名
    // 修改方法名 或者 @Bean("") bean注解中写入值 修改 id
    @Bean
    public Person person(){
        return new Person("李四",20);
    }
}
