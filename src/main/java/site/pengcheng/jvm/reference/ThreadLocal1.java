package site.pengcheng.jvm.reference;

import java.util.concurrent.TimeUnit;

/**
 * @author pengchengbai
 * @description
 * threadlocal最典型的应用，spring中对于transaction的处理
 * 如果一个方法m()是事物的，那么其中所有的方法m1,m2,m3用到的数据库连接，都是同一个连接
 * 这种时候connection就是放在threadlocal中的
 * @date 2020/5/25 9:02 下午
 */
public class ThreadLocal1 {
    
    static ThreadLocal<Person> tl = new ThreadLocal<>();
    
    public static void main(String[] args) {
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(tl.get());
        }).start();


        new Thread(() ->  {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            tl.set(new Person());
        }).start();
    }

}


class Person {
    String name = "zhangsan";
}
