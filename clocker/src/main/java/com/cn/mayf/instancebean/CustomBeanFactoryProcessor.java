package com.cn.mayf.instancebean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @Author mayf
 * @Date 2021/5/3 12:53
 */
@Component
public class CustomBeanFactoryProcessor implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		AbstractBeanDefinition service001 = (AbstractBeanDefinition) beanFactory.getBeanDefinition("service001");
		service001.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);
	}
}
