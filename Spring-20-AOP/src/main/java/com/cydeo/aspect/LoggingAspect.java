package com.cydeo.aspect;

import com.cydeo.controller.CourseController;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Aspect
@Configuration
public class LoggingAspect {

    Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("execution(* com.cydeo.controller.CourseController.*(..))")
    private void pointcut(){
    }

//    @Before("pointcut()")
//    public void log(){
//        logger.info("Logger info ------");
//    }

    @Before("execution(* com.cydeo.controller.CourseController.*(..))")
    public void beforeAdvice(){
        logger.info("Logger info ------");
    }


}
