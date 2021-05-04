package com.cn.mayf.aop;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Author mayf
 * @Date 2021/4/6 21:02
 */
@Component
@Aspect
public class NotVeryUsefulAspect {

	@Pointcut(value = "within(com.cn.mayf.aop.SourceService)")
	private void pointcutAccessCheck(){}

	@Pointcut("execution(* com.cn.mayf.aop.*Service.*(..))")
	private void pointcutTx(){}

	/**
	 * JDK代理时，指向接口和代理类proxy
	 * cglib代理时 指向接口和子类(不使用proxy)
	 */
	@Pointcut("this(com.cn.mayf.aop.TestInterface)")
	public void pointThis(){}

	@After(value = "pointThis()")
	public void doSomethingAfterInterface(){
		System.out.println("do-something after interface!");
	}

	@AfterReturning(value = "pointThis()")
	public void doSomethingAfterReturningInterface(){
		System.out.println("do-something after-return interface!");
	}

	@Before(value = "pointcutAccessCheck()")
	public void doAccessCheck(){
		System.out.println("check access----------");
	}

	@AfterThrowing(throwing = "t",pointcut = "pointcutTx()")
	public void doException(Throwable t){
		System.out.println("get throwable----");
//		t.printStackTrace();
		System.out.println("deal throwable!!!");
	}


//	@Around("pointcutTx()")
	public void doTxAround(ProceedingJoinPoint joinPoint) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
		System.out.println("tx---------"+ Arrays.toString(joinPoint.getArgs()));
		System.out.println(joinPoint.getSignature().getName());
		Class[]clazzs = new Class[joinPoint.getArgs().length];
		for (int i = 0; i < joinPoint.getArgs().length; i++) {
			clazzs[i] = joinPoint.getArgs()[i].getClass();
		}
		//		joinPoint.proceed(joinPoint.getArgs());
		Method method = joinPoint.getTarget().getClass().getMethod(joinPoint.getSignature().getName(),
					clazzs);
		method.invoke(joinPoint.getTarget(),joinPoint.getArgs());

		System.out.println("after-tx--------");
	}

	public static void main(String[] args) {
		for (Method method : SourceService.class.getMethods()) {
			System.out.println(method.getName());
		}
	}
}
