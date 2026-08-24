package com.example.aspect_oriented_programming.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

// Cross cutting is a concern that affects multiple parts of the application.
// Logging is a cross cutting concern because it is used in multiple places in the application.
// Aspect Oriented Programming (AOP) is a programming paradigm that allows us to separate cross cutting concerns from the main business logic.
// In this example, we are using AOP to log method calls in the ShipmentServiceImpl class.
//@Aspect
@Slf4j
@Component
public class LoggingAspect {
    // Advice is the action taken by an aspect at a particular join point. In this example, we are using Before advice to log method calls before they are executed in the ShipmentServiceImpl class.
    // PointCut is a predicate that matches join points. In this example, we are using execution pointcut to match all methods in the ShipmentServiceImpl class.
//    @After("execution(* com.example.aspect_oriented_programming.services.impl.ShipmentServiceImpl.*(..))")
//    @Before("execution(* com.example.aspect_oriented_programming.services.impl.ShipmentServiceImpl.*(..))") // Before annotation to log before method execution in ShipmentServiceImpl
//    @Before("execution(* com.example.aspect_oriented_programming.services.impl.*.*(..))")
    @Before("execution(* orderPackage(..))")
    public void beforeShipmentServiceMethods(JoinPoint joinPoint) { // JointPoint is used to get method signature and other details. Method here is executed before the method execution in ShipmentServiceImpl
        log.info("Before method call: {}", joinPoint.getSignature());
    }

    @After("myLoggingAndAopMethodsPointCut()")
    public void afterMyLoggingAndAopMethodsPointCut() {
        log.info("After My Logging Annotation calls");
    }

    @Before("myLoggingAndAopMethodsPointCut()")
//    @Before("within(com.example.aspect_oriented_programming.services.impl.*)")
    public void beforeServiceImplCalls() {
        log.info("Service Impl calls");
    }

//    @Before("@annotation(org.springframework.transaction.annotation.Transactional)")
//    @Before("@annotation(com.example.aspect_oriented_programming.aspect.MyLogging)")
    @Before("myLoggingAndAopMethodsPointCut()")
    public void beforeTransactionalAnnotationCalls() {
        log.info("Before Transactional Annotation Calls");
    }

    @Pointcut("@annotation(com.example.aspect_oriented_programming.aspect.MyLogging) && within(com.example.aspect_oriented_programming.services.impl.*)")
    public void myLoggingAndAopMethodsPointCut() {

    }
}
