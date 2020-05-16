package site.pengcheng.concurrent.sync;

/**
 * @author pengchengbai
 * @description
 * @date 2020/5/12 11:09 下午
 */
public class Sync implements Runnable {
    private int count = 100;

    // 锁谁都行，这里我们单独new了一个对象来锁，但是通常简单起见都锁当前对象，也就是this
    private Object o = new Object();


    @Override
    public void run() {
        synchronized (o) {
            count --;
            System.out.println(Thread.currentThread().getName() + "count = " + count);
        }
    }
    
    
    public static void main(String[] args) {
        Sync s = new Sync();
        for (int i = 0; i < 100; i ++) {
            new Thread(s, "Thread" + i).start();
        }
    }
}
