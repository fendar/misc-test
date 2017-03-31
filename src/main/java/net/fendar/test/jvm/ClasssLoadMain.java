package net.fendar.test.jvm;

import org.junit.Test;

/**
 * Created by zhongchao on 16/12/6.
 */
public class ClasssLoadMain {

    interface Iface {
        int value = 3;
    }

    class Super {
        protected int value = 5;
    }

    class Sub extends Super implements Iface {

    }

    /**
     * 编译不通过
     * 但是在虚拟机规范中是可以的
     */
    @Test
    public void testParseField() {
        Sub sub = new Sub();
//        System.out.println(sub.value);
    }
}
