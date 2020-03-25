package site.pengcheng.concurrentUtil;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author pengchengbai
 * @description
 * @date 2019-12-15 12:25
 */
public class CountDownLatchDemo {
    private static final int SIZE = 100;
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CountDownLatch latch = new CountDownLatch(SIZE);

        for (int i = 0; i < 5; i ++)
            executorService.execute(new WaitingTask(latch));

        for (int i = 0; i < SIZE; i ++)
            executorService.execute(new TaskPortion(latch));

        System.out.println("launched all tasks");
        // shutdown until all tasks finished
        executorService.shutdown();
    }
}
