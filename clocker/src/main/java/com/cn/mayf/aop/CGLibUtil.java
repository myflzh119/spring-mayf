package com.cn.mayf.aop;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author mayf
 * @Date 2021/4/6 00:03
 */
public class CGLibUtil {
	public static Object getProxyInstance(Class sourceClass){
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(sourceClass);
		enhancer.setCallback(new TestInterceptor());
		return enhancer.create();
	}

	static class TestInterceptor implements MethodInterceptor{

		@Override
		public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
			System.out.println("aop before logic!");
			Object returnVal = proxy.invokeSuper(obj, args);
			System.out.println("aop after logic!");
			return returnVal;
		}
	}
}
