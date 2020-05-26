package site.pengcheng.jvm.reference;

import site.pengcheng.learngeneric.Person;

import java.util.concurrent.TimeUnit;

/**
 * @author pengchengbai
 * @description
 * 虽然看起来操作的是同一个对象，但是不同线程的操作互相是不可见的
 *
 * @date 2020/5/25 9:10 下午
 */
public class ThreadLocal2 {
    static ThreadLocal<Person> tl = new ThreadLocal<>();

    public static void main(String[] args) {
        new Thread(() ->  {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println(tl.get());
        }).start();


        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            tl.set(new Person("zhangsan", 34));
        }).start();

    }
}
