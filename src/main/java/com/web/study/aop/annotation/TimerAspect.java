package com.web.study.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) //해당 메소드가 실행되면 어노테이션을 실행.
@Target({ElementType.METHOD}) //메소드에 적용하는 어노테이션이다.
public @interface TimerAspect {

}
