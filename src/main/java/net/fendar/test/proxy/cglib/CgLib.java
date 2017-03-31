package net.fendar.test.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;

/**
 * Created by zhongchao on 16/4/29.
 */
public class CgLib {
    @SuppressWarnings("unchecked")
    public static <T> T create(T target) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(new Interceptor());
        return (T)enhancer.create();
    }
}
