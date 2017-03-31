package net.fendar.test.spring.processor;

import net.fendar.test.spring.bean.Two;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * Created by zhongchao on 16/7/12.
 */
@Component
public class TestBeanFactoryProcessor implements BeanFactoryPostProcessor {
    //bean 依赖注入在这之后，这个地方只有bean定义
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        Two two = configurableListableBeanFactory.getBean(Two.class);
        System.out.println(two.getOne());
    }
}
