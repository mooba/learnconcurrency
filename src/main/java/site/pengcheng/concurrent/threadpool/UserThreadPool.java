package site.pengcheng.concurrent.threadpool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author pengchengbai
 * @description
 * @date 2020/5/30 3:54 下午
 */
@Slf4j
public class UserThreadPool {

    public static void main(String[] args) {
        UserThreadPool threadPool = new UserThreadPool();
        ThreadPoolExecutor pool = threadPool.getThreadPool();
        ScheduledExecutorService checkPoolThread = Executors.newSingleThreadScheduledExecutor();
//        checkPoolThread.schedule(new CheckThreadPool(pool), 5, TimeUnit.SECONDS);
        checkPoolThread.scheduleAtFixedRate(new CheckThreadPool(pool), 0, 5, TimeUnit.SECONDS);
        for (int i = 0; i < 110; i++) {
            pool.execute(new Task());
        }

        pool.shutdown();
        try {
            pool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("pool is terminated");
        checkPoolThread.shutdownNow();
    }

    ThreadPoolExecutor getThreadPool() {
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("Task-%d").build();
        BlockingQueue<Runnable> q = new LinkedBlockingDeque<>(100);
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MICROSECONDS, q, threadFactory);
        return threadPool;
    }


    private static class Task implements Runnable {
        @Override
        public void run() {
            try {
                log.info("threadName={}", Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    private static class CheckThreadPool implements Runnable {
        private ThreadPoolExecutor poolToBeCheck;

        public CheckThreadPool(ThreadPoolExecutor poolToBeCheck) {
            this.poolToBeCheck = poolToBeCheck;
        }

        @Override
        public void run() {
                    log.info("TaskCount={},ActiveCount={},CompletedTaskCount={},poolSize={},CurrentQueueSize={}",
                            poolToBeCheck.getTaskCount(),
                            poolToBeCheck.getActiveCount(),
                            poolToBeCheck.getCompletedTaskCount(),
                            poolToBeCheck.getPoolSize(),
                            poolToBeCheck.getQueue().size()
                    );
            }
        }

}
