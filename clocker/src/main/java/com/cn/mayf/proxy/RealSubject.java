package com.cn.mayf.proxy;

/**
 * @Author mayf
 * @Date 2021/4/5 10:47
 */
public class RealSubject implements MySubject{

	private String myName;

	public String getMyName() {
		return myName;
	}

	public void setMyName(String myName) {
		this.myName = myName;
	}

	@Override
	public String sayHello(String name) {
		return myName+":hello!"+name+"!";
	}

	@Override
	public void byeToYou(String name) {
		System.out.println(myName+":bye bye!"+name);
	}
}
