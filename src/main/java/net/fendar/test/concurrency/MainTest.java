package net.fendar.test.concurrency;

import org.junit.Test;

import java.util.BitSet;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by zhongchao on 16/8/13.
 */
public class MainTest {
    /**
     * 测试future是否可以多次get
     * 测试结果：可以多次get
     */
    @Test
    public void testFutureMultiGet() throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new Callable<Integer>() {
            public Integer call() throws Exception {
                return 123;
            }
        });

        Thread thread = new Thread(futureTask);

        thread.start();

        //first get
        System.out.println(futureTask.get());

        //second get
        System.out.println(futureTask.get());
    }

    /**
     * 所有parties都到达时，cyclicBarrier的runnable会执行一次
     */
    @Test
    public void testCycleBarrier() {
        final Integer a = 1;

        final CyclicBarrier barrier = new CyclicBarrier(4, new Runnable() {
            public void run() {
                System.out.println(a);
            }
        });

        Thread[] threads = new Thread[4];

        for (int i = 0; i < 4; ++i) {
            threads[i] = new Thread(new Runnable() {
                public void run() {
                    long id = Thread.currentThread().getId();
                    System.out.println("run thread:" + id);
                    try {
                        System.out.println(String.format("thread id:%d, barrier id: %d", id, barrier.await()));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        for (Thread thread : threads)
            thread.start();
    }

    /**
     * schedule异常之后是否执行
     * 对于某个特定的任务，如果出现异常，则该任务后面不会再执行
     * 而对于多个任务，某个任务的异常不会影响到其它任务的执行
     */
    private volatile AtomicInteger scheduleIdx = new AtomicInteger(0);
    @Test
    public void testScheduleException() {
        final ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        final CountDownLatch latch = new CountDownLatch(1);

        Runnable command1 = new Runnable() {
            public void run() {
                scheduleIdx.incrementAndGet();
                System.out.println("task later executing:" + scheduleIdx);

                if (scheduleIdx.get() == 2) {
                    latch.countDown();
                    throw new RuntimeException("thread A throws exception");
                }
                if (scheduleIdx.get() == 3) {
                    System.out.println("thread A executes after exception");
                    scheduledExecutorService.shutdown();
                }
            }
        };

        Runnable command2 = new Runnable() {
            public void run() {
                if (scheduleIdx.get() == 1)
                    System.out.println("command2 executing ");
                else {
                    try {
                        latch.await();
                        System.out.println("command2 executing after Thread A exception");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        };

        scheduledExecutorService.scheduleAtFixedRate(command1, 0, 3, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleAtFixedRate(command2, 0, 4, TimeUnit.SECONDS);

        while (!scheduledExecutorService.isShutdown());
        System.out.println("schedule shut down");
    }

    @Test
    public void testSchedule() {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
            public void run() {
                System.out.println("i am run: " +  atomicInteger.incrementAndGet());
                if (atomicInteger.intValue() == 2) {
                    throw new RuntimeException("test");
                }
            }
        },0 ,3, TimeUnit.SECONDS);

        while (!scheduledExecutorService.isShutdown());
    }
}
