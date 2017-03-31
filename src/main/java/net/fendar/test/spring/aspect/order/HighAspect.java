package net.fendar.test.spring.aspect.order;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * Created by zhongchao on 16/9/21.
 */
@Aspect
@Component
public class HighAspect implements Ordered{
    private static final Logger LOG = LoggerFactory.getLogger(HighAspect.class);

    @Around("target(net.fendar.test.spring.aspect.order.Target)")
    public Object advice(ProceedingJoinPoint jp) throws Throwable {
        LOG.info("high aspect start...");
        Object ret = jp.proceed(new Object[]{"high aspect input"});
        LOG.info("high aspect end...");
        return "high aspect return";
    }

    public int getOrder() {
        return HIGHEST_PRECEDENCE;
    }
}
