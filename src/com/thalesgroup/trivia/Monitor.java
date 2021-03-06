package com.thalesgroup.trivia;

import java.io.PrintStream;
import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Monitor {

	private PrintStream stream = System.out;

//	@Pointcut("execution(** com.thalesgroup.trivia.service.QuestionService.createQuestions(..))")
//	public void pointcut3() {}
//	
//	@Before("pointcut3()")
//	public void beforeMonitorCode3() {
//		stream.println("[Monitor] code before method QuestionService Before!");
//	}
//	
//	@After("pointcut3()")
//	public void afterMonitorCode3() {
//		stream.println("[Monitor] code before method QuestionService After!");
//	}
//	
//	
//	
//	
//	@Pointcut("execution(** com.thalesgroup.trivia.dao.AnswerMapDAO.cre*(..))")
//	public void pointcut2() {
//	}
//	
//	@Before("pointcut2()")
//	public void beforeMonitorCode2() {
//		stream.println("[Monitor] code before method AnswerBefore!");
//	}
//	
//	@After("pointcut2()")
//	public void afterMonitorCode2() {
//		stream.println("[Monitor] code before method AnswerAfter!");
//	}
//	
	
	
	
	
	
	@Pointcut("execution(** com.thalesgroup.trivia.*.*.*(..))")
	public void pointcut1() {
	}

	@Before("pointcut1()")
	public void beforeMonitorCode() {
		stream.println("[Monitor] code before method BEFORE!");
	}

	@After("pointcut1()")
	public void afterMonitorCode() {
		stream.println("[Monitor] code after method AFTER!");
	}

	@Around("pointcut1()")
	public Object aroundSP(ProceedingJoinPoint jp) throws Throwable {
		stream.println("[Monitor] code before method AROUND!");
		
		Object o = jp.proceed();

		stream.println("[Monitor] Method signature: " + jp.getSignature());
		stream.println("[Monitor] Parameters: " + Arrays.asList(jp.getArgs()));
		
		return o;
	}

}
