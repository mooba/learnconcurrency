package site.pengcheng.concurrentUtil;

import java.util.concurrent.CountDownLatch;

/**
 * @author pengchengbai
 * @description
 * @date 2019-12-15 12:17
 */
public class WaitingTask implements Runnable{
    private static int count = 0;
    private final int id = count++;
    private CountDownLatch latch;

    public WaitingTask(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            latch.await();
            System.out.println("latch barrier passed for " + this);
        } catch (InterruptedException ie){
            System.out.println(ie.getMessage());
        }
    }

    @Override
    public String toString() {
        return String.format("WaitingTask %1$-3d ", id);
    }
}
