package com.cn.mayf.aop;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Author mayf
 * @Date 2021/4/5 13:22
 */
@Component
public class SourceService {
//	@PostConstruct
	public void init(){
		System.out.println("@PostConstruct#init()");
	}
	public void doSomething(String name){
		System.out.println(name+" execute"+SourceService.class.getSimpleName()+" do something!");
//		throw new RuntimeException("测试异常!");
	}
}
