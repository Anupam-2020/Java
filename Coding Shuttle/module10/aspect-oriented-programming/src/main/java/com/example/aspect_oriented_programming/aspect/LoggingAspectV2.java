package com.example.aspect_oriented_programming.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspectV2 {

    @Before("allServiceMethodsPointCut()")
    public void beforeServiceMethodCalls(JoinPoint joinPoint) {
        log.info("Before advice method call, {}, {}", joinPoint.getSignature(), joinPoint.getThis());
    }

//    @After("allServiceMethodsPointCut()")
    @AfterReturning(value = "allServiceMethodsPointCut()", returning = "returnObj")
    public void afterServiceMethodCalls(JoinPoint joinPoint, Object returnObj) {
        log.info("After returning advice method call, {}, {}", joinPoint.getSignature(), returnObj);
    }


    @AfterThrowing("allServiceMethodsPointCut()")
    public void afterServiceMethodCallsThrows(JoinPoint joinPoint) {
        log.info("After throwing advice method call, {}, {}", joinPoint.getSignature());
    }

    @Pointcut("execution(* com.example.aspect_oriented_programming.services.impl.*.*(..))")
    public void allServiceMethodsPointCut() {

    }
}
