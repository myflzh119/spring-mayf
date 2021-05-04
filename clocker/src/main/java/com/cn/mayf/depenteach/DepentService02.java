package com.cn.mayf.depenteach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author mayf
 * @Date 2021/3/30 23:01
 */
//@Component("service02")
@Service("service02")
@Primary
public class DepentService02 {
	public DepentService02() {
//		System.out.println(DepentService02.class.getSimpleName() + "产生对象---" + service01);
		System.out.println(DepentService02.class.getSimpleName()+" constor 0");
	}

	/**
	 * 手动装配大于自动装配
	 */
	@Resource
	private DepentService01 service01;

	public DepentService01 getService() {
		return this.service01;
	}

	public DepentService02(DepentService01 service01) {
		System.out.println(DepentService02.class.getSimpleName()+" constor 1");
		System.out.println(service01);
		this.service01 = service01;
	}

	public DepentService02(DepentService01 service01,TestInject val) {
		System.out.println(DepentService02.class.getSimpleName()+" constor 2");
	}


	//	public DepentService01 getService01() {
//		return service01;
//	}
//
//	public void setService01(DepentService01 service01) {
//		System.out.println(service01.getClass()+"===>显示通过setter注入");
//		this.service01 = service01;
//	}
}
