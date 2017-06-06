package net.fendar.test;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


/**
 * Created by zhongchao on 16/12/20.
 */
public class TmpTest {

    public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException {
        TmpTest t = new TmpTest();
        t.test();
    }
    @Test
    public void test() throws IOException, IllegalAccessException, InstantiationException {

        System.out.println(int.class.getClass());

//        System.out.println(reverse(110100));
//        System.out.println(reverse(1));
//        System.out.println(reverse(123456));
//        System.out.println(reverse(510100));
//        System.out.println(reverse(340200));

//        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
//
//        String line ;
//        while (!(line = read.readLine()).equals("end")) {
//            System.out.println(reverse(Integer.parseInt(line)));
//        }
    }

    public int reverse(int i) {
        int res = 0;
        int a = i / 10;
        int b = i % 10;
        while (a > 0) {
            res = res * 10 + b;
            b = a % 10;
            a = a/10;
        }
        return res*10 + b;
    }

    @Test
    public void shiftTest() {
        int b = 0x00fffff0;
        System.out.println(b);
        System.out.println(b << 8 >> 24);
    }

    @Test
    public void testReturnFinally() {
        System.out.println(tt());
    }

    public long tt() {
        try {
            return ss();
        } finally {
            System.out.println("finally");
        }
    }

    @Test
    public void printIntAsBinaryFormat() {
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE).length());
        System.out.println(Integer.toBinaryString(58));
        System.out.println(Integer.parseInt("111001", 2));
    }

    public long ss() {
        System.out.println("try");
        return System.currentTimeMillis()/1000;
    }

    @Test
    public void testQueue() throws InterruptedException, IOException {
        final SynchronousQueue<Integer> q = new SynchronousQueue<>();

        final ThreadPoolExecutor th = new ThreadPoolExecutor(1, 1, 1L , TimeUnit.HOURS, new SynchronousQueue<Runnable>());

        for (int i = 0; i < 10; ++i) {
            final int fi = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        th.submit(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    Thread.sleep(100);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    } catch (Exception e) {
                        System.out.println(fi);
                        e.printStackTrace();
                    }
                }
            }).start();
        }


//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                 q.poll();
//
//                    Thread.sleep(10000);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//        Thread.sleep(1000);

//        for (int i = 0; i < 10; ++i) {
//            final int fi = i;
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        q.put(fi);
//                    } catch (Exception e) {
//                        System.out.println(fi);
//                        e.printStackTrace();
//                    }
//                }
//            }).start();
//        }

        System.in.read();

    }
}
