package site.pengcheng.concurrent.threadpool;

/**
 * @author pengchengbai
 * @description
 * @date 2019-12-15 21:40
 */
public interface ThreadPool<Job extends Runnable> {
    void execute(Job job);

    /**
     * 减少工作线程数
     */
    void removeWorker(int num);

    /**
     * 添加工作线程
     * @param nums
     */
    void addWorkers(int num);

    /**
     * 关闭线程池
     */
    void shutdown();

    Integer getJobSize();
}
