package com.dronezzfly.onetoone.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggingAspect {
    // Define pointcuts for all methods in service layer
    @Pointcut("execution(* com.dronezzfly.onetoone.service.*.*(..))")
    public void serviceMethods() {}

    // Define pointcuts for all methods in controller layer
    @Pointcut("execution(* com.dronezzfly.onetoone.controller.*.*(..))")
    public void controllerMethods() {}

    // Log before service methods execution
    @Before("serviceMethods()")
    public void logBeforeServiceMethod(JoinPoint joinPoint) {
        System.out.println("Executing Service Method: " + joinPoint.getSignature().getName());
        System.out.println("Arguments: " + joinPoint.getArgs());
    }

    // Log after successful execution of service methods
    @AfterReturning(value = "serviceMethods()", returning = "result")
    public void logAfterServiceMethod(JoinPoint joinPoint, Object result) {
        System.out.println("Successfully Executed Service Method: " + joinPoint.getSignature().getName());
        System.out.println("Returned: " + result);
    }

    // Log exceptions thrown by service methods
    @AfterThrowing(value = "serviceMethods()", throwing = "exception")
    public void logServiceMethodException(JoinPoint joinPoint, Throwable exception) {
        System.out.println("Exception in Service Method: " + joinPoint.getSignature().getName());
        System.out.println("Exception: " + exception.getMessage());
    }

    // Repeat similar logging logic for controllers
    @Before("controllerMethods()")
    public void logBeforeControllerMethod(JoinPoint joinPoint) {
        System.out.println("Executing Controller Method: " + joinPoint.getSignature().getName());
    }

}
