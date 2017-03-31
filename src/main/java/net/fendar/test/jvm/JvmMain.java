package net.fendar.test.jvm;

import org.junit.Test;

/**
 * Created by zhongchao on 16/12/4.
 */
public class JvmMain {
    @Test
    public void testReturn() {
        System.out.println(tr());
    }

    /**
     * return 在最外侧，压入final的值，否压入final之前的值
     * @return
     */
    private int tr() {
        int x = 0;
        try {
            x = 1;
            return x;
        } catch (Exception e) {
            x = 2;
            return x;
        } finally {
            x = 3;
        }
//        return x;
    }

    /**
     * 测试浮点数除0
     */
    @Test
    public void testDemicalDivideZero() {
        double d = 0.0 / 0.0;
        System.out.println(d);
    }

    static class InitTest {
        static {
            System.out.println("Init test class init...");
        }
        public static final String sconst = "tse";

        public static final Integer Liconst = 2;

        public static final String sconstCopy = sconst;
    }

    /**
     * 字面常量并不会引起类的初始化
     */
    @Test
    public void testInitClass() {

        System.out.println(InitTest.sconst);
        System.out.println(InitTest.sconstCopy);

    }
}
