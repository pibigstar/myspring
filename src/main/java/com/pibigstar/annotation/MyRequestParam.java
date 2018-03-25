package com.pibigstar.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)//只能注解在参数上
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyRequestParam {
	
	/**
	 * 参数别名  必填
	 * @return
	 */
	String value();

}
