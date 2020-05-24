package site.pengcheng.concurrent.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * @author pengchengbai
 * @description
 * @date 2020/5/18 7:41 下午
 */
@Slf4j
public class TestCounter {
    private static int counter = 0;
    public static void main(String[] args) throws InterruptedException {
        test2();
    }


    public static void test1() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i ++) {
                counter++;
            }
        }, "t1");

        Thread t2 = new Thread(()-> {
            for (int i = 0; i < 5000; i++) {
                counter--;
            }
        }, "t2");

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        log.info("{}", counter);
    }


    public static void test2() throws InterruptedException {
        Room room = new Room();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i ++) {
                room.increment();
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i ++) {
                room.decrement();
            }
        }, "t2");

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        log.info("{}", room.getCounter());
    }
}

// 面下对象改造
class Room {
    private int counter = 0;

    public void increment() {
        synchronized (this) {
            counter ++;
        }
    }


    public void decrement() {
        synchronized (this) {
            counter --;
        }
    }

    public int getCounter() {
        synchronized (this) {
            return counter;
        }
    }
}
