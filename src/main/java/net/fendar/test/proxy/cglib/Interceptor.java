package net.fendar.test.proxy.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by zhongchao on 16/4/29.
 */
public class Interceptor implements MethodInterceptor {

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib interceptor start");
        Object ret = methodProxy.invokeSuper(o, objects);
        System.out.println("cglib interceptor end");
        return ret;
    }
}
