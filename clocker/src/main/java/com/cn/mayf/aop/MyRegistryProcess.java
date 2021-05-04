package com.cn.mayf.aop;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Author mayf
 * @Date 2021/4/6 00:23
 * 自定义注册器，注册需要引入的各种自定义BD
 */
public class MyRegistryProcess implements ImportBeanDefinitionRegistrar {
	@Override
	// 自定义注册BeanDefinition
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
//		System.out.println("begin register Custom-BeanPostProcessor");
		// 注册CustomAopBeanPostProcessor
		registry.registerBeanDefinition("myAopBeanPostProcessor"
				,new RootBeanDefinition(CustomAopBeanPostProcessor.class));
	}
}
