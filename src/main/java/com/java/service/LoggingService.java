package com.java.service;


import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

//@Service
//@Aspect
//public class LoggingService {
//
//	Logger logger= Logger.getLogger(LoggingService.class);
//	
//	@Around(value="within( com.java.controller.*)")
//	public Object log(ProceedingJoinPoint pjp) throws Throwable {
//		logger.info("Entering method "+ pjp.getSignature());
//		Object o=pjp.proceed();
//		logger.info("Exiting method"+ pjp.getSignature());
//		return o;
//	}
//	
//}
