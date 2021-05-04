package com.cn.mayf.aop;

import org.springframework.stereotype.Component;

/**
 * @Author mayf
 * @Date 2021/4/7 20:00
 */
//@Component
public class Test02Impl implements TestInterface{
	@Override
	public void doSomething() {
		System.out.println("this is test02!!!");
	}

	@Override
	public String returnSomething() {
		return null;
	}
}
