package com.test.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * className:WindowsCondition
 * package:com.test.condition
 * Description: 判断当前是否为windows环境
 *
 * @Date:2020/4/418:50
 * @Author:LiangGuang
 */
public class WindowsCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        Environment environment = conditionContext.getEnvironment();
        String property = environment.getProperty("os.name");
        if(property.contains("Windows")){return true;}
        return false;
    }
}
