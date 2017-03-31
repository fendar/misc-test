package net.fendar.test.concurrency.spring;

import java.util.concurrent.*;

/**
 * Created by zhongchao on 16/8/28.
 */
public class ThreadStartTest {
    private ThreadPoolExecutor service = new ThreadPoolExecutor(3, 3, 1000, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());

    private int a;

    {
        service.prestartAllCoreThreads();
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadStartTest test = new ThreadStartTest();

        test.test();
    }

    public void test() throws InterruptedException {
        a = 1;

        service.submit(new Runnable() {
            public void run() {
                System.out.println(a);
                while (a == 0);
                System.out.println("exit....");
            }
        });
        Thread.sleep(1000);

    }
}
