package com.bit.springboard.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutCommon {

	@Pointcut("execution(* com.bit.springboard..*Impl.*(..))")
	public void allPointcut() {}
}
