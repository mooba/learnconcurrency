package site.pengcheng.concurrent.threadpool;

import jdk.nashorn.internal.runtime.WithObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author pengchengbai
 * @description
 * @date 2019-12-15 21:49
 */
public class DefaultThreadPool<Job extends Runnable> implements ThreadPool<Job> {
    private static final int DEFAULT_JOB_SIZE = 10;

    private static final int DEFAULT_WORKER_SIZE = 5;

    private static final int MIN_WORKER_SIZE = 1;

    private static final int MAX_WORKER_SIZE = 10;

    private final LinkedList<Job> jobList = new LinkedList<>();

    private final List<Worker> workers = Collections.synchronizedList(new ArrayList<Worker>());

    private int workerNum = DEFAULT_WORKER_SIZE;

    private AtomicLong threadNum = new AtomicLong();

    public DefaultThreadPool() {
    }


    public DefaultThreadPool(int num) {
        workerNum = num > MAX_WORKER_SIZE ? MAX_WORKER_SIZE : num < MIN_WORKER_SIZE ? MAX_WORKER_SIZE : num;
        initializeWorkers(workerNum);
    }


    private void initializeWorkers(int num) {
        for (int i = 0; i < num; i++) {
            Worker worker = new Worker();
            workers.add(worker);
            Thread workerThread = new Thread(worker, "ThreadPool-worker-" + threadNum.incrementAndGet());
            workerThread.start();
        }
    }


    @Override
    public void execute(Job job) {
        if (job == null) {
            return;
        }

        synchronized (jobList) {
            jobList.add(job);
            jobList.notify();
        }
    }


    @Override
    public void removeWorker(int num) {
        if (num < 0) {
            return;
        }
        synchronized (workers) {
            if (workerNum <= num) {
                throw new IllegalArgumentException("beyond workNum!");
            }

            int count = 0;
            while (count < num) {
                Worker worker = workers.remove(count);
                worker.shutDown();
                count++;
            }
            this.workerNum -= count;
        }
    }


    @Override
    public void addWorkers(int num) {
        if (num < 0) {
            return;
        }
        synchronized (workers) {
            if (workerNum + num > MAX_WORKER_SIZE) {
                num = MAX_WORKER_SIZE - workerNum;
            }
            initializeWorkers(num);
            workerNum += num;
        }
    }


    @Override
    public void shutdown() {
        for (Worker worker: workers) {
            worker.shutDown();
        }
    }


    @Override
    public Integer getJobSize() {
        return jobList.size();
    }


    /**
     * 工作者，负责处理jobList中的job
     */
    class Worker implements Runnable {
        // 标记是否运行
        private  volatile boolean running = true;

        @Override
        public void run() {
            while (running) {
                Job job = null;
                synchronized (jobList) {
                    if (jobList.isEmpty()) {
                        try {
                            jobList.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    // equivalent to removeFirst()
                    job = jobList.remove();
                }

                if (job != null) {
                    try {
                        job.run();
                    } catch (Exception e) {
                        // 暂时忽略Job执行中的异常
                    }
                }
            }
        }

        public void shutDown() {
            running = false;
        }
    }

}
