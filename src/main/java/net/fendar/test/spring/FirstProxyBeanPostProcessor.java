package net.fendar.test.spring;

import net.fendar.test.spring.annotation.Mark;
import net.fendar.test.spring.bean.TargetIface;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by zhongchao on 16/5/3.
 */
@Component
public class FirstProxyBeanPostProcessor implements BeanPostProcessor, Ordered {
    private static final Logger LOG = LoggerFactory.getLogger(FirstProxyBeanPostProcessor.class);

    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        return o;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (!beanName.equals("person"))
            return bean;

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(bean);
//        proxyFactory.setInterfaces(TargetIface.class);
//        proxyFactory.addAdvisor(new DefaultPointcutAdvisor(new AnnotationMatchingPointcut(null, Mark.class), new MyAdvice()));
        proxyFactory.addAdvice(new MethodInterceptor() {
            public Object invoke(MethodInvocation invocation) throws Throwable {
                Method method = invocation.getMethod();
                System.out.println(method);
                System.out.println(method.getAnnotation(Mark.class));

                return invocation.proceed();
            }
        });

        return proxyFactory.getProxy();
    }

    public int getOrder() {
        return HIGHEST_PRECEDENCE;
    }

    class MyAdvice implements MethodInterceptor {
        public Object invoke(MethodInvocation invocation) throws Throwable {
            LOG.info("spring aop advice start....");
            return invocation.proceed();
        }
    }
}
