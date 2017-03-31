package net.fendar.test.jvm;

import org.junit.Test;

/**
 * Created by zhongchao on 16/8/23.
 */
public class JvmHook {


    public static void main(String[] args) {

    }

    /**
     * jvm非正常退出，SIGKILL等是不会运用钩子的
     */
    @Test
    public void testJVMHook() {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.out.println("bye~");
            }
        });

        while(true);
    }

    /**
     * sigint/SIGKILL都不会允许finally
     */
    @Test
    public void testFinally() {
        try {
            while(true);
        } finally {
            System.out.println("bye~");
        }
    }
}
