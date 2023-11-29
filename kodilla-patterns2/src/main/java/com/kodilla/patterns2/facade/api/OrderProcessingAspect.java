package com.kodilla.patterns2.facade.api;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class OrderProcessingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderProcessingAspect.class);

    @Before("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))")
    public void beforeProcessOrder(JoinPoint joinPoint) {
        LOGGER.info("Before executing processOrder()");
    }

    @After("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))")
    public void afterProcessOrder(JoinPoint joinPoint) {
        LOGGER.info("After executing processOrder()");
    }
}
