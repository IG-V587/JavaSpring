package com.test.config;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * className:MyTypeFilter
 * package:com.test.config
 * Description:
 *
 * @Date:2020/4/417:37
 * @Author:LiangGuang
 */
public class MyTypeFilter implements TypeFilter {
    /**
     *
     * @param metadataReader    读取到的当前正在扫描的类的信息
     * @param metadataReaderFactory 可以获取到其他任何类信息的
     * @return
     * @throws IOException
     */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {

        // 获取当前类注解信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        // 获取当前正在扫描的类的信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        // 获取当前类的资源信息 （类路径）
        Resource resource = metadataReader.getResource();
        String className = classMetadata.getClassName();
        System.out.println("---->"+className);

        // 自定义规则，根据上面 获取到的各种属性，进行自定义过滤规则
        // 返回true 则表示进行扫描生成bean，
        // 返回false 则不进行扫描
        if(className.contains("Controller")){
            return true;
        }
        return false;
    }
}
