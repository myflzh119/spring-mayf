package com.cn.mayf.depenteach;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @Author mayf
 * @Date 2021/3/31 20:33
 */
//@Component
public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
	@Override
	public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
		System.out.println("doing "+MyInstantiationAwareBeanPostProcessor.class.getSimpleName());
		return false;
	}
}
