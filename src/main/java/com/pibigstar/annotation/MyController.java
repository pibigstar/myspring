package com.pibigstar.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 创建自己的Controller注解，它只能标注在类上面：
 * @author pibigstar
 *
 */
@Target(ElementType.TYPE)//在类上的注解
@Retention(RetentionPolicy.RUNTIME)//运行时
@Documented
public @interface MyController {

	/***
	 * 给Controller起别名
	 * @return
	 */
	String value() default "";
	
}
