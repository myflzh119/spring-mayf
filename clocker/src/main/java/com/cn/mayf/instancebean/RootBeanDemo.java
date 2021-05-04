package com.cn.mayf.instancebean;

import com.cn.mayf.depenteach.DepentService01;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Author mayf
 * @Date 2021/4/9 22:55
 */
public class RootBeanDemo {
	DepentService01 service01;

	public RootBeanDemo(DepentService01 service01) {
		System.out.println("use DepentService01-method "+service01);
	}
//
//	@Autowired(required = false)
//	public RootBeanDemo(String str){
//		System.out.println("有且仅有一个带参构造方法:" + str + "\t且没有值注入");
//	}
//
//	public RootBeanDemo(String str,String str2){
//		System.out.println("有两个个带参构造方法:" + str + "\t"+str);
//	}

	//	@Autowired(required = false)
//	public RootBeanDemo(TestDemo demo) {
//		System.out.println(demo.getClass().getSimpleName());
//	}

//	@Autowired(required = false)
//	public RootBeanDemo() {
//		System.out.println("no args!");
//	}

//	@Autowired(required = false)
//	public RootBeanDemo(TestDemo demo,String str) {
//		System.out.println(demo.getClass().getSimpleName()+"++"+str);
//	}

//	@Autowired(required = false)
	public RootBeanDemo(int num,Object obj){
		System.out.println("cons obj:"+obj+"----num:"+num);
	}

//	public RootBeanDemo(String str) {
//		System.out.println(str);
//	}

}
