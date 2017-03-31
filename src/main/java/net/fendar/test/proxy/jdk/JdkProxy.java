package net.fendar.test.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by zhongchao on 16/4/29.
 */
public class JdkProxy {
    public static void main(String[] args) {

        final IfaceImpl impl = new IfaceImpl();

        Iface ifaceProxy = (Iface) Proxy.newProxyInstance(JdkProxy.class.getClassLoader(), IfaceImpl.class.getInterfaces(), new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("proxy start");
                Object ret = method.invoke(impl, args);
                System.out.println("proxy end");
                return ret;
            }
        });

        ifaceProxy.test();
    }

    @SuppressWarnings("unchecked")
    public static <T> T getJdkProxy(final T target) {
        return (T)Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("jdk proxy start");
                Object ret = method.invoke(target, args);
                System.out.println("jdk proxy end");
                return ret;
            }
        });
    }
}
