package net.fendar.test.concurrency.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Created by zhongchao on 16/8/21.
 * 在application创建后启动的线程能看到spring对对象进行的更改
 * 但是之前的线程是可能看不见更改的
 */
public class SpringSafePunishTest {

    private SafePunishSpring safePunishSpring;

    public static void main(String[] args) throws InterruptedException {

        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:spring/concurrent/Application-context-spring-safe-punish.xml");


        Thread.sleep(100000);
    }

    public void setSafePunishSpring(SafePunishSpring safePunishSpring) {
        System.out.println("main set...");
        this.safePunishSpring = safePunishSpring;
    }
}
