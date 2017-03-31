package net.fendar.test.proxy.cglib;


import net.fendar.test.proxy.jdk.Iface;
import net.fendar.test.proxy.jdk.IfaceImpl;
import net.fendar.test.proxy.jdk.JdkProxy;

/**
 * Created by zhongchao on 16/4/29.
 */
public class CglibProxy  {


    public static void main(String[] args) {
        IfaceImpl impl = new IfaceImpl();
        Iface cgLib, cgLib2,  jdkProxy, jdkProxy2;


        cgLib = CgLib.create(impl);

//        cgLib2 = CgLib.create(cgLib);

        jdkProxy = JdkProxy.getJdkProxy(impl);

        jdkProxy2 = JdkProxy.getJdkProxy(jdkProxy);

        cgLib2 = CgLib.create(jdkProxy2);

        jdkProxy2.test();
    }
}
