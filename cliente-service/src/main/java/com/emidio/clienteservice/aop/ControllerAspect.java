package com.emidio.clienteservice.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * ControllerAspect
 */
@Aspect
@Component
public class ControllerAspect {

    private static final Logger logger = LoggerFactory.getLogger(ControllerAspect.class);

    @Before("within(com.emidio.clienteservice.controller.ClienteController)")
    private void before(JoinPoint joinPoint){

        String chamador = joinPoint.getSignature().toString();
        
      //  Object[] args = joinPoint.getArgs();
        
        String argumentos = joinPoint.getArgs().toString();


        logger.info(String.format("Aspecto funcionando: Chamador: %s. Argumentos: %s.", chamador, argumentos));
    }
}