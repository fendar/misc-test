package net.fendar.test.jvm;

import java.util.concurrent.CountDownLatch;

/**
 * Created by zhongchao on 16/7/7.
 */
public class OneThreadStackOverFlow {

    private  int length = 0;

    private int alength  = 0;

    private CountDownLatch countDownLatch = new CountDownLatch(1);

    /**
     * -Xss160k ---> length 750
     * -Xss255k ---> length 4846
     */
    public void stackLeak() {
        length++;
        stackLeak();
    }

    /**
     * -Xss160k ---> length 515
     * -Xss255k ---> length 3331
     */
    public void stackLeak(long a, double b, float c) {
        length++;
        stackLeak(a+1, b+2.0, c+3.1F);
    }

    public static void main(String[] args) throws Exception {
        OneThreadStackOverFlow stackOverFlow = new OneThreadStackOverFlow();


//        stackOverFlow.noLocalVar();
//        stackOverFlow.localVar();

        /**
         * error
         */
        stackOverFlow.newThread();
        Thread.sleep(10);
        stackOverFlow.testa();
    }

    public void noLocalVar() throws Exception {
        try {
            stackLeak();
        } catch (Throwable e) {
            System.out.println("now stack length is:" + length);
            Thread.sleep(1);
            e.printStackTrace();
        }
    }

    public void localVar() throws Exception {
        try {
            stackLeak(1000, 1212.12321, 12313.12F);
        } catch (Throwable e) {
            System.out.println("now stack length is:" + length);
            Thread.sleep(1);
            e.printStackTrace();
        }
    }

    public void testa() throws Exception {
        length++;
        if (length < 740)
            testa();
        else {
            countDownLatch.countDown();
            Thread.sleep(300000);
        }
    }

    public void newThread() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    countDownLatch.await();
                    System.out.println("thread execute");
                    threadStack();
                } catch (Throwable e) {
                    e.printStackTrace();
                    System.out.println("length:" + length + "\talength:" + alength);
                }

            }
        });

        thread.start();

    }

    public void threadStack() {
        alength++;
        threadStack();
    }
}
