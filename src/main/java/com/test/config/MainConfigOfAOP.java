package com.test.config;

import com.test.aop.LogAspects;
import com.test.aop.MathCaluator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


/**
 * AOP:
 *      在程序运行期间，动态的将某段代码切入到指定方法、指定位置进行运行的编程方式
 *
 *      1、导入AOP模块：SpringAOP:    spring-aspects
 *      2、定义一个业务逻辑类（MathCaluator）；在业务逻辑运行时打印日志（方法运行前，方法运行后，方法运行中，方法异常。。。。）
 *      3、定义一个日志切面类（LogAspects）：切面类中的方法需要动态感知 MathCaluator.div 运行到什么地方
 *             通知方法；
 *                      前置通知 (@Before)：logStart:在目标方法运行开始之前
 *                      后置通知 (@After)：logEnd:在目标方法运行结束之后
 *                      返回通知 (@AfterReturn)：logReturn:在目标方法正常返回之后运行
 *                      异常通知 (@AfterThrowing)：logException:在目标方法出现异常后运行
 *                      环绕通知 (@Around)：动态代理，手动推进目标方法运行（JoinPoint.procced()）
 *      4、给切面类的目标方法标注何时运行（通知注解）
 *      5、将切面类和目标方法类（业务逻辑类） 都加入到容器中
 *      6、告诉Spring哪个是切面类 添加注解 @Aspect
 *      [7]、给配置类加 @EnableAspectJAutoProxy 注解  【开启注解模式的AOP】
 *              在后续的Spring中 会有 @Enablexxx，作用是开启某一项功能
 *
 *
 *
 *  总结为 3 步
 *          1、将业务逻辑和切面类都注入到ioc容器中，并告诉spring 哪个是切面类 （使用 @Aspect注解）
 *          2、在切面类上的每个通知方法添加注解，告诉spring运行时机 （注意 切入表达式）
 *          3、开启基于注解的 AOP 模式  @EnableAspectJAutoProxy
 *
 *
 */
@EnableAspectJAutoProxy
@Configuration
public class MainConfigOfAOP {

    @Bean
    public MathCaluator mathCaluator(){
        return new MathCaluator();
    }
    @Bean
    public LogAspects logAspects(){
        return new LogAspects();
    }
}
