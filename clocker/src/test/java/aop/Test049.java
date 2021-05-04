package aop;

import com.cn.mayf.aop.*;
import com.cn.mayf.depenteach.DepentService01;
import com.cn.mayf.depenteach.DepentService02;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Method;

/**
 * @Author mayf
 * @Date 2021/4/3 11:45
 * BeanPostProcessor==>改变、创建一个对象(Bean)
 *   不同的时机，执行不同的BeanPostProcessor的不同的方法，实现不同的功能
 *   其中有一个功能需要实现==>传进一个Bean，生成一个被代理的Bean
 *   ==>AbstractAutoProxyCreator.postProcessAfterInitialization
 */
public class Test049 {
	@Test
	public void test(){
		AnnotationConfigApplicationContext aca = new AnnotationConfigApplicationContext();

		/*aca.register(AppConfigExcludeFilters.class);
		aca.refresh();

		DepentService01 service01 = (DepentService01) aca.getBean("service01");
		System.out.println(service01.getService());
		System.out.println(aca.getBean("service222"));
		DepentService02 service02 = (DepentService02) aca.getBean("service02");*/

		aca.register(AppConfig049.class);
//		aca.registerBeanDefinition("myAopBeanPostProcessor",
//				new RootBeanDefinition(CustomAopBeanPostProcessor.class));
		aca.refresh();

//		aca.getBean(SourceService.class).doSomething("mayf");

		TestInterface bean = aca.getBean(TestInterface.class);

		for (Method method : bean.getClass().getDeclaredMethods()) {
			System.out.println(method.getName());
		}

//		System.out.println(aca.getBean(TestInterface.class).returnSomething());
	}

}
