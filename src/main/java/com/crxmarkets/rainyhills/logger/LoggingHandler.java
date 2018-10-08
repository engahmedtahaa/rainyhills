package com.crxmarkets.rainyhills.logger;

import java.util.Arrays;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
/** 
* @desc LoggingHandler which logs API request and parameters depending on AOP
* @author AhmedTaha
*/
@Aspect
@Component
public class LoggingHandler {

	Logger log = LoggerFactory.getLogger(this.getClass());

	@Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
	public void controller() {
	}

	
	
	@Before("execution(* com.crxmarkets.rainyhills.controller.*.*(..))")
	public void logBefore(JoinPoint joinPoint) {

		log.debug("Entering in Method :  " + joinPoint.getSignature().getName());
		log.debug("Class Name :  " + joinPoint.getSignature().getDeclaringTypeName());
		log.debug("Arguments :  " + Arrays.toString(joinPoint.getArgs()));
		log.debug("Target class : " + joinPoint.getTarget().getClass().getName());
	}
	
	
	
	
	
	@Around("execution(* com.crxmarkets.rainyhills.controller.*.*(..))")
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		
		long start = System.currentTimeMillis();
		try {
			String className = joinPoint.getSignature().getDeclaringTypeName();
			String methodName = joinPoint.getSignature().getName();
			Object result = joinPoint.proceed();
			long elapsedTime = System.currentTimeMillis() - start;
			log.debug("Method " + className + "." + methodName + " ()" + " execution time : "
					+ elapsedTime + " ms");
		
			return result;
		} catch (IllegalArgumentException e) {
			log.error("Illegal argument " + Arrays.toString(joinPoint.getArgs()) + " in "
					+ joinPoint.getSignature().getName() + "()");
			throw e;
		}
	}
	
	
	
	@Around("execution(* com.crxmarkets.rainyhills.service.*.**(..))")
    public Object logMethod(ProceedingJoinPoint joinPoint) throws Throwable{
        final Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass().getName());
        Object retVal = null;

        try {
            StringBuffer startMessageStringBuffer = new StringBuffer();

            startMessageStringBuffer.append("Start method ");
            startMessageStringBuffer.append(joinPoint.getSignature().getName());
            startMessageStringBuffer.append("(");

            Object[] args = joinPoint.getArgs();
            for (int i = 0; i < args.length; i++) {
                startMessageStringBuffer.append(args[i]).append(",");
            }
            if (args.length > 0) {
                startMessageStringBuffer.deleteCharAt(startMessageStringBuffer.length() - 1);
            }

            startMessageStringBuffer.append(")");

            logger.debug(startMessageStringBuffer.toString());

            StopWatch stopWatch = new StopWatch();
            stopWatch.start();

            retVal = joinPoint.proceed();

            stopWatch.stop();

            StringBuffer endMessageStringBuffer = new StringBuffer();
            endMessageStringBuffer.append("Finish method ");
            endMessageStringBuffer.append(joinPoint.getSignature().getName());
            
            endMessageStringBuffer.append("(..); in : "+joinPoint.getSignature().getDeclaringTypeName());
            endMessageStringBuffer.append("execution time: ");
            endMessageStringBuffer.append(stopWatch.getTotalTimeMillis());
            endMessageStringBuffer.append(" ms;");
            logger.debug(endMessageStringBuffer.toString());
        } catch (Throwable ex) {
            StringBuffer errorMessageStringBuffer = new StringBuffer();

             // Create error message 
             logger.error(errorMessageStringBuffer.toString(), ex);

            throw ex;
        }

        return retVal;
    }
	
	
	
	@SuppressWarnings("unused")
	private String getValue(Object result) {
		String returnValue = null;
		if (null != result) {
			if (result.toString().endsWith("@" + Integer.toHexString(result.hashCode()))) {
				returnValue = ReflectionToStringBuilder.toString(result);
			} else {
				returnValue = result.toString();
			}
		}
		return returnValue;
	}
}
