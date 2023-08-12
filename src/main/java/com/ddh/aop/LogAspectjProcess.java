package com.ddh.aop;

import com.ddh.annotation.AuditLog;
import com.ddh.config.LogProperties;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LogAspectjProcess {

    @Autowired
     private LogProperties logProperties;

    /**
     * 定义切点
     */
    @Pointcut("@annotation(com.ddh.annotation.AuditLog)")
    public void pointCut(){}


    @Around("pointCut() && @annotation(auditLog)")
    public Object around(ProceedingJoinPoint pjp, AuditLog auditLog)
    {
        String taskName = pjp.getSignature()
                .toString().substring(
                        pjp.getSignature()
                                .toString().indexOf(" "),
                        pjp.getSignature().toString().indexOf("("));
        taskName = taskName.trim();
        long time = System.currentTimeMillis();
        Object result = null;
        try {
            result = pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        log.info("{} -- method:{} run :{} ms",logProperties.getPlatform(), taskName,
                (System.currentTimeMillis() - time));
        return result;




    }

}
