package com.cn.mayf.aop;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Author mayf
 * @Date 2021/4/7 19:54
 */
@Component(value = "test01")
//@Lazy
public class TestImpl implements TestInterface{
	@Override
	public void doSomething() {
		Class<?>[] interfaces = this.getClass().getInterfaces();
		System.out.println(this.getClass());
		System.out.println(Arrays.toString(interfaces));
	}

	@Override
	public String returnSomething() {
		return String.valueOf(this.hashCode());
	}

	public void privateMethod(){

	}
}
