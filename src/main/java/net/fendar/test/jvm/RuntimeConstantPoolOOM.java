package net.fendar.test.jvm;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhongchao on 16/7/7.
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) throws InterruptedException {
        List<Object> list = new ArrayList<Object>();
       while (true) {
           try {
               Enhancer enhancer = new Enhancer();
               enhancer.setSuperclass(OOMObject.class);
               enhancer.setUseCache(false);
               enhancer.setCallback(new MethodInterceptor() {
                   @Override
                   public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                       return methodProxy.invokeSuper(o, objects);
                   }
               });
               list.add(enhancer.create());
           } catch (Throwable e) {
               e.printStackTrace();
               Thread.sleep(12131321);
           }
       }
    }

    static class OOMObject {

    }
}
