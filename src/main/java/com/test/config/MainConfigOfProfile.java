package com.test.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @Profile :指定组件在哪个环境的情况下才能被注册到容器中，不指定，任何环境下都能注册这个组件
 *
 * 1、加了环境标识的bean，只有这个环境被激活的时候才能注册到容器中，默认是default 环境
 * 2、写在配置类上，只有是指定的环境的时候，整个配置类李曼的所有配置才能开始生效
 * 3、没有标注环境标识的bean，在任何环境下都是加载的，前提是该配置类生效
 */
@PropertySource("classpath:/dbDataSource.properties")
@Configuration
public class MainConfigOfProfile implements EmbeddedValueResolverAware {

    @Value("${db.user}")
    private String userName;

    private StringValueResolver valueResolver;

    private String driverClass;

    @Profile("test")
    @Bean("testDataSource")
    public DataSource dataSourceTest(@Value("${db.password}") String pwd) throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource=new ComboPooledDataSource();
        comboPooledDataSource.setUser(userName);
        comboPooledDataSource.setPassword(pwd);
        comboPooledDataSource.setDriverClass(driverClass);
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        return comboPooledDataSource;
    }

    @Profile("dev")
    @Bean("dataSourceDev")
    public DataSource dataSourceDev(@Value("${db.password}") String pwd) throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource=new ComboPooledDataSource();
        comboPooledDataSource.setUser(userName);
        comboPooledDataSource.setPassword(pwd);
        comboPooledDataSource.setDriverClass(driverClass);
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/dev");
        return comboPooledDataSource;
    }

    @Profile("prod")
    @Bean("dataSourceProd")
    public DataSource dataSourceProd(@Value("${db.password}") String pwd) throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource=new ComboPooledDataSource();
        comboPooledDataSource.setUser(userName);
        comboPooledDataSource.setPassword(pwd);
        comboPooledDataSource.setDriverClass(driverClass);
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/prod");
        return comboPooledDataSource;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {
        this.valueResolver=stringValueResolver;
        driverClass=valueResolver.resolveStringValue("${db.driverClass}");
    }
}
