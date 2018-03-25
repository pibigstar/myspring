package com.pibigstar.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * RequestMapping注解，可以在类和方法上：
 * @author pibigstar
 *
 */
@Target({ElementType.TYPE,ElementType.METHOD})//可以在类上和方法上
@Retention(RetentionPolicy.RUNTIME)//运行时
@Documented
public @interface MyRequestMapping {

	/**
	 * 表示访问该方法的url
	 * @return
	 */
	String value() default "";
}
