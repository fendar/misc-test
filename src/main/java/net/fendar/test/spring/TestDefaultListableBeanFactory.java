package net.fendar.test.spring;

import net.fendar.test.util.Prints;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by zhongchao on 16/3/28.
 */
public class TestDefaultListableBeanFactory {
    public static void main(String[] args) {
        ClassPathResource resource = new ClassPathResource("spring/beans.xml");
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.setAllowBeanDefinitionOverriding(false);

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions(resource);
        Prints.print(beanFactory.getBeanDefinitionCount());
        ((Person)beanFactory.getBean("person")).work();
    }

}
