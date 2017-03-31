package net.fendar.test.concurrency.task;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by zhongchao on 16/9/10.
 */
public class TaskClose {


    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        final CountDownLatch latch = new CountDownLatch(1);

        Future<?> future = executorService.submit(new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().toString());
                System.out.println(Thread.currentThread().isInterrupted());
                latch.countDown();
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println("fdsfsd");
                }
                System.out.println(Thread.currentThread().isInterrupted());
                System.out.println(Thread.currentThread().toString());
            }
        });
        latch.await();
        future.cancel(true);

        executorService.submit(new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().toString());
                System.out.println(Thread.currentThread().isInterrupted());
            }
        });
    }

    @Test
    public void testClose() throws InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        final CountDownLatch latch = new CountDownLatch(1);

        Future<?> future = executorService.submit(new Runnable() {
            public void run() {
                latch.countDown();
                while (true) {
                    System.out.println("fdsfsd");
                }
            }
        });
        latch.await();
//        future.cancel(false);

    }
}
