package net.fendar.test.spring.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by zhongchao on 16/5/3.
 */
@Aspect
@Component
public class AspectBean {
    private static final Logger LOG = LoggerFactory.getLogger(AspectBean.class);

    @Pointcut("execution(public * net.fendar.test.spring.aspect.*.*(..))")
    private void servicePoint() {

    }

    @Around("servicePoint()")
    public Object doAround(ProceedingJoinPoint jp) throws Throwable {
        LOG.info("do around start");
        return jp.proceed();
    }
}
