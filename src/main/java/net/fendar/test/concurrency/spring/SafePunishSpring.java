package net.fendar.test.concurrency.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhongchao on 16/8/21.
 * 都能看见val的改变
 */
public class SafePunishSpring implements InitializingBean {
    public int val = 0;

    public volatile int monitor;

    public SafePunishSpring() {
        System.out.println("construct init... val:" + val);
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

        scheduledExecutorService.schedule(new Runnable() {
            public void run() {
                while (val == 0) {
                    //happens-before可以保证
//                    int r = monitor;
                }
                System.out.println("construct exit...");
            }
        }, 0, TimeUnit.SECONDS);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }





    public void afterPropertiesSet() throws Exception {
        val = 4;
        monitor = 1;
    }
}
