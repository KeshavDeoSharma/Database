package com.learn.database.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Around("(@annotation(com.learn.database.util.LogExecutionTime))")
    public Object logExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        Long startTime = System.currentTimeMillis();
        String methodName = joinPoint.getSignature().getName();
        log.info("Starting execution method :{}", methodName);
        Object result = joinPoint.proceed();
        log.info("Ended execution method: {}, with time taken: {} ms", methodName, System.currentTimeMillis() - startTime);
        return result;
    }
}
