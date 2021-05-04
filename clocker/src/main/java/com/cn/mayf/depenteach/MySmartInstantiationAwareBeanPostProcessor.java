package com.cn.mayf.depenteach;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @Author mayf
 * @Date 2021/4/2 20:05
 */
@Component
public class MySmartInstantiationAwareBeanPostProcessor implements SmartInstantiationAwareBeanPostProcessor {
	@Override
	public Object getEarlyBeanReference(Object bean, String beanName) throws BeansException {
//		System.out.println("Bean---" + bean.getClass().getSimpleName() + " 进入了MySmartInstantiationAwareBeanPostProcessor！");
//		System.out.println("beanName is " + beanName);
		return bean;
	}
}
