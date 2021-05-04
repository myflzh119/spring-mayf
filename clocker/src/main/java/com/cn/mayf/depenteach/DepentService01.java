package com.cn.mayf.depenteach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @Author mayf
 * @Date 2021/3/30 23:01
 */
//@Component
@Component("service01")
//@DependsOn("depentService02")
public class DepentService01 {

	public DepentService01() {
//		System.out.println(DepentService01.class);
//		System.out.println(DepentService01.class.getSimpleName()+"产生对象---"+service02);
	}

	/**
	 * 构造器注入时如果会执行参数最少的那个方法，固此方法会失效
	 * @param service02
	 */
//	public DepentService01(DepentService02 service02) {
//		System.out.println("通过构造器非显示注入");
//		this.service02 = service02;
//	}

	// 非显示的setter注入
	@Autowired
	DepentService02 service02;

	public DepentService02 getService() {
		return this.service02;
	}

	public void setService02(DepentService02 service02) {
		System.out.println("执行service02的setter方法");
	}

	//	public DepentService02 getService02() {
//		return service02;
//	}
//
////	@Autowired
//	public void setService02(DepentService02 service02) {
//		System.out.println("显示通过setter注入");
//		this.service02 = service02;
//	}
}
