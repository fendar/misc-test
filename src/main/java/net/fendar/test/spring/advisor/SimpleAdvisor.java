package net.fendar.test.spring.advisor;

import net.fendar.test.spring.bean.TargetIface;
import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DefaultPointcutAdvisor;

/**
 * Created by zhongchao on 16/7/22.
 */
public class SimpleAdvisor extends DefaultPointcutAdvisor {

    private TargetIface targetIface;

    private final Advice advice = new MethodInterceptor() {
        public Object invoke(MethodInvocation invocation) throws Throwable {
            System.out.println("advice intercept....");
            if (invocation.getThis().equals(targetIface)) {
                System.out.println("my advice");
            }
            //no adivce
            return invocation.proceed();
        }
    };

    public SimpleAdvisor() {
        setAdvice(advice);
    }

    public void setTargetIface(TargetIface targetIface) {
        this.targetIface = targetIface;
    }
}
