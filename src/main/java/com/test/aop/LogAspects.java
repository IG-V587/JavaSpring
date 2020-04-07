package com.test.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

// @Aspect 告诉spring 这是一个切面类
@Aspect
public class LogAspects {

    //抽取公共的切入点表达式
    // 1、本类引入   直接写方法名
    // 2、其他的切面引入  全路径加名称
    @Pointcut(" execution ( public int com.test.aop.MathCaluator.*(..)) ")
    public void pointCut(){

    }

    // @Before 在目标方法之前切入 切入点表达式
    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        System.out.println(joinPoint.getSignature().getName()+"运算。。参数列表是{"+ Arrays.asList(args) +"}");
    }
    @After("pointCut()")
    public void logEnd(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName()+"结束。。。");
    }

    // JoinPoint 必须出现在参数的第一位
    @AfterReturning(value = "pointCut()",returning = "result")
    public void logReturn(JoinPoint joinPoint,Object result){
        System.out.println(joinPoint.getSignature().getName()+"正常返回 ，，返回结果是{"+result+"}");
    }

    @AfterThrowing(value = "pointCut()",throwing = "e")
    public void logException(JoinPoint joinPoint,Exception e){
        System.out.println(joinPoint.getSignature().getName()+"异常，异常原因是：{"+e.getMessage()+"}");
    }
}
