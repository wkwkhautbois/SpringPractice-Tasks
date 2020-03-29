package dev.wkwk.tasks.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class RepositoryLogAspect {
    @Around("execution(* dev.wkwk..*.*Repository.*(..))")
    public Object startLog(ProceedingJoinPoint jp) throws Throwable {
        log.info("REPOSITORY INTO: {}", jp.getSignature());
        log.debug("args {}", jp.getArgs());
        try {
            Object result = jp.proceed();
            log.info("REPOSITORY OUT: {}", jp.getSignature());
            return result;
        } catch (Exception e) {
            log.info("REPOSITORY EXCEPTION: {}", jp.getSignature());
            throw e;
        }
    }
}
