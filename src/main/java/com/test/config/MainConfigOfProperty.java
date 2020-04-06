package com.test.config;

import com.test.entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:person.properties")
@Configuration
public class MainConfigOfProperty {
    @Bean
    public Person person(){
        return new Person();
    }
}
