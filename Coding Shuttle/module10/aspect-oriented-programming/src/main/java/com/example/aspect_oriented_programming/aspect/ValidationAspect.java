package com.example.aspect_oriented_programming.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class ValidationAspect {

    @Pointcut("execution(* com.example.aspect_oriented_programming.services.impl.*.*(..))")
    public void allServiceMethodsPointCut() {

    }

    @Around("allServiceMethodsPointCut()") // Around advice is different from @Before advice, because it allows us to control the execution of the method and even modify the return value if needed.
    public Object validateOrderId(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object[] args = proceedingJoinPoint.getArgs();
        Long orderId = (Long) args[0];

        if(orderId > 0) return proceedingJoinPoint.proceed();

        return "Cannot call with negative order id";
    }
}
