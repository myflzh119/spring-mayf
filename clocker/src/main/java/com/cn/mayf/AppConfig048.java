package com.cn.mayf;

import com.cn.mayf.depenteach.DepentService01;
import com.cn.mayf.depenteach.DepentService02;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author mayf
 * @Date 2021/3/30 23:04
 */
@Configuration
@ComponentScan("com.cn.mayf.depenteach")
public class AppConfig048 {

	@Bean
	public DepentService02 getDepencyService02(){
		return new DepentService02();
	}

	@Bean("service01_copy")
	public DepentService01 getDS01(){return new DepentService01();}

//	@Override
//	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
//
//	}
}
