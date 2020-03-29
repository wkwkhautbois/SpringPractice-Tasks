package dev.wkwk.tasks.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class ControllerLogAspect {
    @Around("execution(* dev.wkwk..*.*Controller.*(..))")
    public Object startLog(ProceedingJoinPoint jp) throws Throwable {
        log.info("CONTROLLER INTO: {}", jp.getSignature());
        log.debug("args {}", jp.getArgs());
        try {
            Object result = jp.proceed();
            log.info("CONTROLLER OUT: {}", jp.getSignature());
            log.debug("RETURN: {}", result);
            return result;
        } catch (Exception e) {
            log.info("CONTROLLER WARN: {}", jp.getSignature());
            throw e;
        }
    }
}
