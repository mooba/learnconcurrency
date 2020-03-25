package site.pengcheng.threadpool;

import org.omg.CORBA.PRIVATE_MEMBER;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author pengchengbai
 * @description
 * @date 2019-12-15 21:49
 */
public class DefaultThreadPool<Job extends Runnable> implements ThreadPool {
    private static final int DEFAULT_JOB_SIZE = 10;

    private static final int DEFAULT_WORKER_SIZE = 5;

    private static final int MIN_WORKER_SIZE = 1;

    private static final int MAX_WORKER_SIZE = 10;

    private final LinkedList<Job> jobList = new LinkedList<>();

    private final List<Worker> workers = Collections.synchronizedList(new ArrayList<Worker>());

    @Override
    public void execute(Runnable runnable) {

    }

    @Override
    public void removeWorker(int num) {

    }

    @Override
    public void addWorkers(int nums) {

    }

    @Override
    public void shutdown() {

    }

    @Override
    public Integer getJobSize() {
        return null;
    }


    class Worker implements Runnable {
        @Override
        public void run() {

        }
    }
}
