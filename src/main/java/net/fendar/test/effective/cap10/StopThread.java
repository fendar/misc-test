package net.fendar.test.effective.cap10;

/**
 * Created by zhongchao on 16/6/5.
 */
public class StopThread {
    private static boolean stopRequested = false;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10000; i++) {
            TestStop testStop = new TestStop();
            testStop.run();
        }
    }

    static class TestStop {
        private  boolean  stop = false;


        public void run() throws InterruptedException {
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    int i = 0;
                    while (!stop) {
                        i++;
                    }
                }
            });

            thread.start();

//            Thread.sleep(1);

            stop = true;
        }
    }
}
