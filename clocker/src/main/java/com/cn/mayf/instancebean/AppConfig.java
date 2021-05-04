package com.cn.mayf.instancebean;


import com.cn.mayf.depenteach.DepentService01;
import com.cn.mayf.depenteach.DepentService02;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author mayf
 * @Date 2021/4/9 22:53
 */
//@Configuration
@ComponentScan("com.cn.mayf.instancebean")
public class AppConfig {
	@Bean
	public DepentService02 getService02(){
		return new DepentService02();
	}

	@Bean("service001")
	public DepentService01 getService01(){
		return new DepentService01();
	}
}
