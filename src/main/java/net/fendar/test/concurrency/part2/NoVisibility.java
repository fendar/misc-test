package net.fendar.test.concurrency.part2;

import java.util.concurrent.*;

/**
 * Created by zhongchao on 16/4/18.
 */
public class NoVisibility {
    private static boolean ready = false;
    private static int number;

    private static ExecutorService executorService = Executors.newSingleThreadExecutor();

    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            while (!ready)
                Thread.yield();
            System.out.println(number);
        }
    }





    public static void main(String[] args) {


        for (int i = 0; i < 2000; ++i) {
            new ReaderThread().start();
        }
        number = 42;
        ready = true;
    }
}
