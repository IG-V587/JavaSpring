package com.test.config;

import com.test.condition.LinuxConditon;
import com.test.condition.MyImportBeanDefinitionRegistrar;
import com.test.condition.MyImportSelector;
import com.test.condition.WindowsCondition;
import com.test.entity.Person;
import com.test.entity.Student;
import org.springframework.context.annotation.*;

/**
 * className:MainConfig2
 * package:com.test.config
 * Description:
 *
 * @Date:2020/4/418:05
 * @Author:LiangGuang
 */
@Configuration
@Import({Student.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
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
     *
     * @Lazy  懒加载   针对单实例情况
     * 单实例bean 默认在容器启动时进行创建
     *              懒加载，容器启动时不创建对象，第一次获取（使用）bean对象时进行创建，并初始化
     *
     */
//    @Scope("singleton")
    @Lazy
    @Bean
    public Person person(){
        return new Person("张三",22);
    }

    /**
     * @Conditional({Condition})    按照一定的条件进行判断，满足条件则给容器中注册bean
     * condition 表达式 ，如果正确返回true 则表示 生成
     *
     * @return
     */

    @Conditional(WindowsCondition.class)
    @Bean("bill")
    public Person person01(){
        return new Person("bill gates",66);
    }

    @Conditional(LinuxConditon.class)
    @Bean("linus")
    public Person person02(){
        return new Person("linus",50);
    }


    /**
     * 给容器中注册组件
     * 1、包扫描+组件标注注解  （@Controller、@Service、@Repository、@Component）
     * 2、@Bean【导入的第三方包里面的组件】
     * 3、@Import [快速给容器中导入一个组件]
     *      1、@Import (要导入到容器中的组件) 容器中就会自动注册这个组件,id默认为全类名
     *      2、ImportSelector  返回需要导入的组件的全类名数组
     *      3、ImportBeanDefinitionRegistrar 手动注册bean 到容器中
     *
     *
     *
     */
}
