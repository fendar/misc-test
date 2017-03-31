package net.fendar.test.spring.advisor;

import net.fendar.test.spring.annotation.Mark;
import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DefaultPointcutAdvisor;

import java.lang.reflect.Method;

/**
 * Created by zhongchao on 16/12/6.
 */
public class MethodAnnotationAdvisor extends DefaultPointcutAdvisor {

    private final Advice advice = new MethodInterceptor() {
        public Object invoke(MethodInvocation invocation) throws Throwable {
            Method method = invocation.getMethod();
            System.out.println(method);
            System.out.println(method.getAnnotation(Mark.class));

            return invocation.proceed();
        }
    };

    public MethodAnnotationAdvisor() {
        setAdvice(advice);
    }

}
