package net.fendar.test.concurrency.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhongchao on 16/8/21.
 */
public class SafePunishBeanPostProcessor implements BeanPostProcessor {

    private volatile int monitor;


    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        if (!(o instanceof SafePunishSpring))
            return o;

        final SafePunishSpring safePunishSpring = (SafePunishSpring) o;


        System.out.println("before init... val: " + safePunishSpring.val);
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

        scheduledExecutorService.schedule(new Runnable() {
            public void run() {

                while (safePunishSpring.val == 0) {
                    int r = safePunishSpring.monitor;
                }
                System.out.println("before init exit...");
            }
        }, 0, TimeUnit.SECONDS);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return o;
    }

    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {

        if (!(o instanceof SafePunishSpring))
            return o;

        final SafePunishSpring safePunishSpring = (SafePunishSpring) o;


        System.out.println("after init... val:" + safePunishSpring.val);
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

        scheduledExecutorService.schedule(new Runnable() {
            public void run() {
                while (safePunishSpring.val == 0) {

                }
                System.out.println("after init exit...");
            }
        }, 0, TimeUnit.SECONDS);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return o;
    }
}
