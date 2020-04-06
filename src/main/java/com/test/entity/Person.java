package com.test.entity;

import org.springframework.beans.factory.annotation.Value;

/**
 * className:person
 * package:com.test.entity
 * Description:
 *
 * @Date:2020/4/416:21
 * @Author:LiangGuang
 */
public class Person {

    /**
     * 属性赋值
     * @Value
     * 1、基本数值 ，string，Boolean，int等等
     * 2、spel表达式  #{}   如  #{30-2}
     * 3、可以写${}  取出配置文件中的值（在运行环境变量里面的值）
     */
    @Value("张三")
    private String name;
    @Value("#{30-1}")
    private Integer age;

    @Value("${person.nickName}")
    private String nickName;// 昵称

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
