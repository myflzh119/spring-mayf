package com.cn.mayf.aop;

import org.springframework.context.annotation.*;
import org.springframework.context.annotation.ComponentScan.Filter;

/**
 * @Author mayf
 * @Date 2021/4/5 13:21
 */
@Configuration
@EnableAspectJAutoProxy/*(proxyTargetClass = true)*/
//@MyRegistry
@ComponentScan(value = "com.cn.mayf.aop",excludeFilters = {
		@Filter(type = FilterType.ASSIGNABLE_TYPE,value = AppConfigExcludeFilters.class)
})
public class AppConfig049 {

	private class InnerClass{
		public InnerClass() {
		}

		private int num;
	}
}
