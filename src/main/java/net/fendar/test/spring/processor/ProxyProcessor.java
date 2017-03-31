package net.fendar.test.spring.processor;

import net.fendar.test.spring.bean.TargetIface;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.util.List;

/**
 * Created by zhongchao on 16/7/22.
 */
public class ProxyProcessor implements BeanPostProcessor {


    private List<Advisor> advisors;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof TargetIface && !beanName.equals("person")) {
            ProxyFactory proxyFactory = new ProxyFactory();
            proxyFactory.setTarget(bean);
            proxyFactory.setInterfaces(TargetIface.class);
            proxyFactory.setProxyTargetClass(false);
            proxyFactory.addAdvisors(advisors);

            return proxyFactory.getProxy();
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        return bean;
    }

    public void setAdvisors(List<Advisor> advisors) {
        this.advisors = advisors;
    }
}
