package com.cn.mayf.aop;

import com.cn.mayf.depenteach.DepentService02;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @Author mayf
 * @Date 2021/4/3 11:31
 */
@Configuration
/**
 * 过滤器只对扫描有用，对注入等其他注解无效果
 * 使用@Bean加载的Bean是由Bean工厂生产，也不在过滤范围内
 * 同时注意扫描到其他@ComponentScan类，会打破本过滤器规则
 */
@ComponentScan(value = "com.cn.mayf",
		excludeFilters = {
			@Filter(type = FilterType.CUSTOM,classes = {AppConfigExcludeFilters.MyFilterType.class}),
			@Filter(type = FilterType.ANNOTATION,value = Service.class),
			@Filter(type = FilterType.ASSIGNABLE_TYPE,value = DepentService02.class)
		})
public class AppConfigExcludeFilters {
	 public static class MyFilterType implements TypeFilter {
	 	
	 	private Class[] types = {Configuration.class,ComponentScan.class};
		@Override
		@SuppressWarnings("unchecked")
		public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {

			AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();

			if(annotationMetadata.getClassName().contains("AppConfig049"))return false;

			MergedAnnotations annotations = annotationMetadata.getAnnotations();

			for (Class type :
					types) {
				if(annotations.isPresent(type))return true;
			}

			return false;
		}
	}

	@Bean
	public DepentService02 service222(){
	 	return new DepentService02();
	}
}
