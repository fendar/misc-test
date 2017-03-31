package net.fendar.test.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhongchao on 16/5/10.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        executorService.submit(new Runnable() {
            public void run() {
                countDownLatch.countDown();
                System.out.println("i`m running");
            }
        });

        countDownLatch.await();
        System.out.println("end");
    }
}
