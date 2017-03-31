package net.fendar.test.concurrency;

import org.junit.Test;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhongchao on 16/8/20.
 */
public class ExecutorsMain {
    @Test
    public void completionService() {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        CompletionService<Integer> completionService =
                new ExecutorCompletionService<Integer>(executorService);

        completionService.poll();

//        Runtime.getRuntime().addShutdownHook();
    }
}
