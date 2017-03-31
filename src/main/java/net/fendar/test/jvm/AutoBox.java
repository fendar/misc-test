package net.fendar.test.jvm;

//import org.junit.Test;

/**
 * Created by zhongchao on 16/12/18.
 */
public class AutoBox {
    /**
     * 实际的结果和备注的结果不一致！！！
     */
//    @Test
//    public void mainTest() {
//        Integer a = 1;
//        Integer b = 2;
//        Integer c = 3;
//        Integer d = 3;
//        Integer e = 321;
//        Integer f = 321;
//        Long g = 3L;
//
//        System.out.println(c == d); //true
//        System.out.println(e == f); //false
//        System.out.println(c == (a + b)); // false
//        System.out.println(c.equals(a + b)); //true
//        System.out.println(g == (a + b));//false
//        System.out.println(g.equals(a + b));//false
//    }

    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;

        System.out.println(c == d); //true
        System.out.println(e == f); //false
        System.out.println(c == (a + b)); // false ---> true
        System.out.println(c.equals(a + b)); //true
        System.out.println(g == (a + b));//false ----> true
        System.out.println(g.equals(a + b));//false
    }
}
