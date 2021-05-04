package com.cn.mayf.proxy.cglib;

import com.cn.mayf.proxy.RealSubject;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Author mayf
 * @Date 2021/4/5 11:38
 */
public class MyMethodInterceptor implements MethodInterceptor {

	/**
	 * @param obj 修改行为的对象实例自己
	 * @param method 被拦截的方法
	 * @param args 被拦截方法的参数
	 * @param proxy 触发父类方法的对象
	 * @return
	 * @throws Throwable
	 *
	 * this.var10000.intercept(this, CGLIB$sayHello$0$Method, CGLIB$emptyArgs, CGLIB$sayHello$0$Proxy);
	 */
	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
//		System.out.println(obj.getClass());
//		System.out.println(method);
//		System.out.println(Arrays.toString(args));
		System.out.println(method);
		Object returnVal = null;
		returnVal = proxy.invokeSuper(obj,args);
//		returnVal = method.invoke(method.getDeclaringClass().newInstance(), args);
//		System.out.println(returnVal);
		return returnVal;
	}
}
