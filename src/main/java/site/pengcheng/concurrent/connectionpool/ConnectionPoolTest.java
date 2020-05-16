package site.pengcheng.concurrent.connectionpool;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author pengchengbai
 * @description
 * @date 2019-12-15 13:32
 */
public class ConnectionPoolTest {
    static ConnectionPool pool = new ConnectionPool(10);
    // 保证所有子线程能够同时执行
    static CountDownLatch start = new CountDownLatch(1);

    static CountDownLatch end;

    public static void main(String[] args) throws InterruptedException{
        int threadCount = 20;
        end = new CountDownLatch(threadCount);

        AtomicInteger got = new AtomicInteger();
        AtomicInteger notGot = new AtomicInteger();

        // 每个线程获取的连接的数量
        int count = 20;
        for (int i = 0; i < threadCount; i ++) {
            Thread thread = new Thread(new ConnectionRunner(got, notGot, count), "ConnectionRunner Thread" + i);
            thread.start();
        }

        // 各个线程同时开始执行业务逻辑部分
        System.out.println("ready to start at the same time");
        start.countDown();

        // 等待各个子线程执行完毕
        end.await();

        System.out.println("total invoke:" + (threadCount * count));
        System.out.println("got in total: " + got);
        System.out.println("not got in total: " + notGot);

    }


    static class ConnectionRunner implements Runnable {
        AtomicInteger got;
        AtomicInteger notGot;
        private int count;

        public ConnectionRunner(AtomicInteger got, AtomicInteger notGot, int count) {
            this.got = got;
            this.notGot = notGot;
            this.count = count;
        }

        @Override
        public void run() {
            try {
                // 等待主线程提供执行信号
                start.await();
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException ie) {
                System.out.println("err");
            }

            for (int i = 0; i < count; i ++) {
                try {
                    Connection connection = pool.fetchConnection(1000);
                    if (connection != null) {
//                        System.out.println("got the " + i + " connection in " + Thread.currentThread().getName());
                        try {
                            connection.createStatement();
                            connection.commit();
                        } catch (SQLException sqe) {
                            System.out.println(sqe.getMessage());
                        } finally {
                            pool.releaseConnection(connection);
                            got.incrementAndGet();
                        }
                    } else {
                        notGot.incrementAndGet();
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }

            end.countDown();
        }

    }
}
