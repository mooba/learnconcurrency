package site.pengcheng.jvm.reference;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author pengchengbai
 * @description
 * @date 2020/5/25 8:22 下午
 */
public class NormalReferenceTest {
    public static void main(String[] args) throws IOException {
        M m = new M();
        m = null;
        System.gc();

        // 并不是在main线程里面回收垃圾，而是在单独的线程中, 所以需要这样一个方法来等待垃圾回收线程回收完
        System.in.read();
    }
}
