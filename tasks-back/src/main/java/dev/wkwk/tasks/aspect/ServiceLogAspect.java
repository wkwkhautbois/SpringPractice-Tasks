package dev.wkwk.tasks.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class ServiceLogAspect {
    @Around("execution(* dev.wkwk..*.*Service.*(..))")
    public Object startLog(ProceedingJoinPoint jp) throws Throwable {
        log.info("SERVICE INTO: {}", jp.getSignature());
        log.debug("args {}", jp.getArgs());
        try {
            Object result = jp.proceed();
            log.info("SERVICE OUT: {}", jp.getSignature());
            return result;
        } catch (Exception e) {
            log.info("SERVICE EXCEPTION: {}", jp.getSignature());
            throw e;
        }
    }
}
