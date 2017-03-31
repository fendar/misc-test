package net.fendar.test.spring;

import net.fendar.test.proxy.cglib.CgLib;
import net.fendar.test.util.Prints;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * Created by zhongchao on 16/5/3.
 */
@Component
public class SecondProxyBeanPostProcessor implements BeanPostProcessor, Ordered {
    private static final Logger LOG = LoggerFactory.getLogger(SecondProxyBeanPostProcessor.class);

    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        return o;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    public int getOrder() {
        return LOWEST_PRECEDENCE;
    }
}
