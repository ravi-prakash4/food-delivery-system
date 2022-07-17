package com.project.BuyerFrontend.aop;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Aop {
	
	@Before("execution(* com.project.BuyerFrontend.*.*.*.*(*) )"
			+ " || execution(* com.project.BuyerFrontend.controller.AppController.home(*) )"
			+ " || execution(* com.project.BuyerFrontend.*.*.*(*) )"
			+ " || execution(* com.project.BuyerFrontend.*.*.*.*() )"
			+ " || execution(* com.project.BuyerFrontend.*.*.*() )")
	public void logBeforeFunctionExecution(JoinPoint joinPoint) {
		String methodName=((MethodSignature) joinPoint.getSignature()).getMethod().getName().toString();
		System.out.println();
		System.out.println("VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV");
		System.out.println("          "+methodName+" Method of Class "+joinPoint.getTarget().getClass().getCanonicalName()+" Execution Started At : "+new Date());
	}
	
	@After("execution(* com.project.BuyerFrontend.*.*.*.*(*) )"
			+ " || execution(* com.project.BuyerFrontend.*.*.*(*) )"
			+ " || execution(* com.project.BuyerFrontend.*.*.*.*() )"
			+ " || execution(* com.project.BuyerFrontend.*.*.*() )")
	public void logAfterFunctionExecution(JoinPoint joinPoint) {
		String methodName=((MethodSignature) joinPoint.getSignature()).getMethod().getName().toString();
		
		System.out.println("          "+methodName+" Method of Class "+joinPoint.getTarget().getClass().getName()+" Execution Ended At : "+new Date());
		System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		System.out.println();
	}

}
