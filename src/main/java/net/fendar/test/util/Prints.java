package net.fendar.test.util;

/**
 * Created by zhongchao on 16/3/26.
 */
public class Prints {
    public static void println(Object... args) {
        for (Object arg : args) {
            System.out.println(arg);
        }
    }

    public static void print(Object... args) {
        for (Object arg: args) {
            System.out.print(arg);
        }
        System.out.println();
    }
}
