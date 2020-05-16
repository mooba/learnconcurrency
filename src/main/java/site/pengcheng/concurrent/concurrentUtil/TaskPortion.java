package site.pengcheng.concurrent.concurrentUtil;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author pengchengbai
 * @description
 * @date 2019-12-15 12:03
 */
public class TaskPortion implements Runnable{
    private static int counter = 0;
    private final int id = counter++;
    private static Random rand = new Random(47);

    private final CountDownLatch latch;

    public TaskPortion(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try{
            doWork();
            latch.countDown();
        } catch (InterruptedException ie) {
            System.out.println(ie.getMessage());
        }

    }

    public void doWork() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(rand.nextInt(2000));
        System.out.println(this + " complete");
    }

    @Override
    public String toString() {
        return String.format("%1$-3d ", id);
    }
}
