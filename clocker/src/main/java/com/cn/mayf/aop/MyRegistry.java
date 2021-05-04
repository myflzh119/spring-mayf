package com.cn.mayf.aop;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @Author mayf
 * @Date 2021/4/6 00:22
 * 自定义标签，将注册器Import
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(MyRegistryProcess.class)
public @interface MyRegistry {
}
