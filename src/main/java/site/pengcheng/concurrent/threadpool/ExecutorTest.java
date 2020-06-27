package site.pengcheng.concurrent.threadpool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author pengchengbai
 * @description
 * @date 2020/5/30 5:46 下午
 */
public class ExecutorTest {

    public static void main(String[] args) {
        ExecutorService service1 = Executors.newFixedThreadPool(10);
        ExecutorService service2 = Executors.newSingleThreadExecutor();

        ScheduledExecutorService service3 = Executors.newSingleThreadScheduledExecutor();

        ScheduledThreadPoolExecutor service4 = new ScheduledThreadPoolExecutor(1, new ThreadFactoryBuilder().setNameFormat("task-%d").build());

        DelayQueue q = new DelayQueue();
//        q.take();


    }
}
