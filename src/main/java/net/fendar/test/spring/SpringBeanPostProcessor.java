package net.fendar.test.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;

/**
 * Created by zhongchao on 16/5/3.
 */
@Component
public class SpringBeanPostProcessor implements BeanPostProcessor {
    public static final Logger LOG = LoggerFactory.getLogger(SpringBeanPostProcessor.class);

    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        return o;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        String proxy = Proxy.isProxyClass(bean.getClass()) ? "jdk proxy" : (bean.getClass().getName().contains("$$") ? "cglib proxy" : "false");

        String proxy = AopUtils.isJdkDynamicProxy(bean) ? "jdk proxy" : (AopUtils.isCglibProxy(bean) ? "cglib proxy": "false");
        LOG.info("bean name: {}, bean class: {}, proxy: {}", new Object[]{beanName, bean.getClass(), proxy});
        return bean;
    }

}
