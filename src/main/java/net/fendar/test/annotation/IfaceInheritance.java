package net.fendar.test.annotation;

import net.fendar.test.proxy.jdk.JdkProxy;
import org.junit.Test;
import org.springframework.aop.framework.AopProxyUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

/**
 * Created by zhongchao on 16/12/5.
 */
public class IfaceInheritance {
    interface Iface {
        @Exam
        void work();
    }

    class IfaceImplA implements Iface {
        public void work() {

        }
    }

    /**
     * 三个都没有@Exam注解
     * @throws NoSuchMethodException
     */
    @Test
    public void test() throws NoSuchMethodException {
        Iface iface = new IfaceImplA();
        IfaceImplA implA = new IfaceImplA();
        Iface proxy = JdkProxy.getJdkProxy(implA);

        System.out.printf("iface work method has exam annotation is:%s\n", iface.getClass().getMethod("work").getAnnotation(Exam.class));
        System.out.printf("implA work method has exam annotation is:%s\n", implA.getClass().getMethod("work").getAnnotation(Exam.class));
        System.out.printf("proxy work method has exam annotation is:%s\n", proxy.getClass().getMethod("work").getAnnotation(Exam.class));
    }

    @Test
    public void test2() throws NoSuchMethodException {
        Iface iface = new IfaceImplA();
        IfaceImplA implA = new IfaceImplA();
        Iface proxy = JdkProxy.getJdkProxy(implA);

        Method ifaceMethod = iface.getClass().getMethod("work").getDeclaringClass().getMethod("work");
        Method implMethod = implA.getClass().getMethod("work").getDeclaringClass().getMethod("work");
        Method proxyMethod = proxy.getClass().getMethod("work").getDeclaringClass().getMethod("work");

        for (Class<?> c: iface.getClass().getInterfaces()) {
            System.out.println(c.getMethod("work"));
            System.out.println(hasAnnotation(c.getMethod("work"), Exam.class));
        }

        System.out.println(ifaceMethod);
        System.out.println(implMethod);
        System.out.println(proxyMethod);
        System.out.printf("iface clz :%s\n", hasAnnotation(ifaceMethod, Exam.class));
        System.out.printf("impl clz :%s\n", hasAnnotation(implMethod, Exam.class));
        System.out.printf("proxy clz :%s\n", hasAnnotation(proxyMethod, Exam.class));
    }

    public boolean hasAnnotation(AnnotatedElement ae, Class<? extends Annotation> annotation) {
        if (ae.getAnnotation(annotation) != null)
            return true;
//        for (Annotation a : ae.getAnnotations()) {
//            if (a.annotationType().getAnnotation(annotation) != null)
//                return true;
//        }
        return false;
    }
}
