package net.fendar.test.spring;

import net.fendar.test.spring.aspect.order.Target;
import net.fendar.test.spring.bean.TargetA;
import net.fendar.test.spring.bean.TargetB;
import net.fendar.test.spring.bean.TargetIface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by zhongchao on 16/5/3.
 */
@Component
public class AppStart {
    private static final Logger LOG = LoggerFactory.getLogger(AppStart.class);

    public static void main(String[] args) throws Exception {
        System.out.println("application loading...");
        LOG.info("application starting...");

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/Application-context.xml");
        AppStart main = context.getBean(AppStart.class);

        Target target = context.getBean(Target.class);

        TargetIface targetB = context.getBean("targetB", TargetIface.class);


        System.out.println(targetB.getClass());
        targetB.work();

        TargetIface person = context.getBean("person", TargetIface.class);
        System.out.println(person.getClass());
        System.out.println(person.getClass().getMethod("work"));
        person.work();

        System.in.read();
    }

}
