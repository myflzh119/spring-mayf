package com.cn.mayf.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author mayf
 * @Date 2021/4/5 10:48
 */
public class InvocationHandlerImpl implements InvocationHandler {
	private Object realSub;

	public InvocationHandlerImpl(Object realSub) {
		this.realSub = realSub;
	}

	/**
	 * @param proxy 用来实现多级代理
	 * @param method
	 * @param args
	 * @return
	 * @throws Throwable
	 *
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("正在代理的方法名==="+method.getName());
		/**
		 * proxy是生成字节码的对象的自己本身
		 * 所以当只有一个Proxy对象时，调用proxy的方法，它会反复调用自己!
		 * 但在多级代理中，会传递到下一层代理中
		 */
		System.out.println("是否属于Proxy?===>"+(proxy instanceof Proxy));
		Object returnVal = method.invoke(realSub, args);
		return returnVal;
	}
}
