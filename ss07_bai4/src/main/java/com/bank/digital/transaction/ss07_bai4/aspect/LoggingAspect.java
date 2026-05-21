package com.bank.digital.transaction.ss07_bai4.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @AfterThrowing(
            pointcut = "execution(* com.bank.digital.transaction.ss07_bai4.service..*.*(..))",
            throwing = "exception"
    )
    public void logServiceException(JoinPoint joinPoint, Throwable exception) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getSignature().getDeclaringType().getSimpleName();
        String args = Arrays.toString(joinPoint.getArgs());

        log.error("INTERNAL ERROR LOG -> [{}.-{}] failed with arguments: {}. Chi tiết lỗi: ",
                className, methodName, args, exception);
    }
}