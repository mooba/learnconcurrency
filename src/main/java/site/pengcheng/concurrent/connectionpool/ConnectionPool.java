package site.pengcheng.concurrent.connectionpool;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * @author pengchengbai
 * @description 一个简易的数据库连接池，参考《Java并发编程的艺术》
 * @date 2019-12-08 17:03
 */
public class ConnectionPool {
    private static int defaultInitialSize = 10;

    private LinkedList<Connection> pool = new LinkedList<>();

    public ConnectionPool() {
        this(defaultInitialSize);
    }

    public ConnectionPool(int initialSize) {
        for (int i = 0; i < initialSize; i ++) {
            pool.addLast(ConnectionDriver.createConnection());
        }
    }

    /**
     * 释放连接需要发送通知，告诉阻塞在此的线程有新的连接可用
     * 并且还要把该连接放回连接池中
     * @param connection
     */
    public void releaseConnection(Connection connection) {
        if (connection != null) {
            synchronized (pool) {
                pool.notifyAll();
                pool.addLast(connection);
            }
        }
    }

    /**
     * 获取连接，如果超时时间小于等于0
     * @param mills
     */
    public Connection fetchConnection(long mills) throws InterruptedException{
        synchronized (pool) {
            if (mills <= 0) {
                while (pool.isEmpty()) {
                    pool.wait();
                }
                return pool.removeFirst();
            } else {
                long future = System.currentTimeMillis() + mills;
                long remaining = mills;
                while (pool.isEmpty() && remaining > 0) {
                    pool.wait(remaining);
                    remaining = future - System.currentTimeMillis();
                }
                Connection connection = null;
                if (!pool.isEmpty()) {
                    connection = pool.removeFirst();
                }
                return connection;
            }
        }
    }


}
