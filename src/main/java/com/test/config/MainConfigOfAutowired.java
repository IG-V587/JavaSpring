package com.test.config;

import com.test.dao.BookDao;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *自动装配
 *      spring利用依赖注入（DI），完成对IOC容器中各个组件的依赖关系赋值
 *
 * 1、@Autowried:自动注入
 *          1、默认优先按照类型去容器中找对应的组件：applicationContext.getBean(BookDao.class)
 *
 *          ---------此处实际测试报错，返回的是config下返回的  此处存疑---------
 *          2、如果找到多个相同类型的组件，再将属性的名称作为组件的id去容器中查找
 *          3、@Qualifier("bookDao"),使用@Qualifier指定需要装配的组件的id，而不是使用属性名
 *          -------------------2、3 存疑----
 *
 *          4、自动装配默认一定要将属性赋好值，没有就会报错
 *              可以使用@Autowired(required=false)
 *          5、@Primary,让spring自动装配时，默认使用首选的bean
 *          -- @Primary 首选 同时存在@Qualifier 则优先@Qualifier
 *          -- 但是实际测试 @Qualifier 使用还是会报错，而且同时使用时 @Primary 显示结果
 *          -- 此处存疑
 *
 *2、Spring还支持使用@Resource(JSR250规范) 和@Inject(JSR330规范)  【Java规范的注解】
 * @Resource:
 *      可以和@Autowired 一样实现自动装配功能，默认是按照组件名称进行装配；
 *      没有支持@Primary功能，没有支持@Autowired(required=false)
 *
 * @Inject:
 *      需要导入javax.inject 包，和@Autowired的功能一样，但是没有 required=false 功能
 *
 *
 *
 *
 *
 */
@Configuration
@ComponentScan({"com.test.dao","com.test.service","com.test.controller"})
public class MainConfigOfAutowired {

//    @Primary    // 首选
//    @Bean("bookDao2")
    public BookDao bookDao(){
        BookDao bookDao = new BookDao();
        bookDao.setTag("2");
        return bookDao;
    }

}
