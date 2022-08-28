package cn.zybcn.core.handler;

import lombok.SneakyThrows;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.StandardAnnotationMetadata;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * @Author ZhangYiBo
 * @Date 2022-08-27 23:17
 */
@Configuration
public class HandlerBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        AnnotationAttributes annotationAttributes = AnnotationAttributes.fromMap(importingClassMetadata.getAnnotationAttributes(HandlerScan.class.getName()));
        String[] scanPackages;
        if (annotationAttributes == null) {
            //为定义注解 就设置当前启动类所在包路径
            scanPackages = new String[]{((StandardAnnotationMetadata) importingClassMetadata).getIntrospectedClass().getPackage().getName()};
        } else {
            scanPackages = annotationAttributes.getStringArray("scanPackage");
        }
        //获取包扫描
        ClassPathScanningCandidateComponentProvider pathScanningCandidateComponentProvider = new ClassPathScanningCandidateComponentProvider(false);
        //添加过滤 带有Handler这个注解的类
        pathScanningCandidateComponentProvider.addIncludeFilter(new AnnotationTypeFilter(Handler.class));

        LinkedHashSet<BeanDefinition> candidateComponents = new LinkedHashSet<>();
        for (String basePackages : scanPackages) {
            candidateComponents.addAll(pathScanningCandidateComponentProvider.findCandidateComponents(basePackages));
        }
        //注册Bean
        for (BeanDefinition candidateComponent : candidateComponents) {
            String beanName = candidateComponent.getBeanClassName();
            registry.registerBeanDefinition(beanName, candidateComponent);
        }

    }
}
