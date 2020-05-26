package site.pengcheng.jvm.reference;


import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;

/**
 * @author pengchengbai
 * @description
 * 堆外内存不归gc管，也就是不归jvm管，但是归Hotspot的c++程序管
 * 原来在读取外部文件的时候需要走os 内核，然后到缓冲区，然后被拷贝到jvm中，这个过程很慢
 * 所以现在可以用一个jvm中的引用直接指向堆外的内存，减少数据拷贝，这技术成为zero copy
 * 为了解决管理堆2外内存，这种引用对象被回收了，jvm得有办法把它指向的对外内存清理掉
 *
 * 这个对象需要有个钩子机制来告诉jvm去清理堆外内存
 * 虚引用就是提供这种钩子机制
 *
 * 设置-Xmx20M
 * @date 2020/5/25 8:37 下午
 */
public class PhantomReferenceTest {
    private static final List<Object> list = new LinkedList<>();
    private static final ReferenceQueue<M> QUEUE = new ReferenceQueue<>();

    public static void main(String[] args) {
        PhantomReference<M> phantomReference = new PhantomReference<>(new M(), QUEUE);
        System.out.println(phantomReference.get());

        new Thread(() -> {
            while (true) {
                list.add(new byte[2014 * 1024]);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        }).start();

        // 模拟垃圾回收线程
        new Thread(() -> {
            while (true) {
                Reference<? extends M> poll = QUEUE.poll();
                if (poll != null) {
                    System.out.println("虚引用被jvm回收了" + poll);
                }
            }
        }).start();
    }


    // 虚引用的应用
    private void testNio() {
        ByteBuffer b1 = ByteBuffer.allocate(1014);

        // 这个就是在堆外直接分配
        ByteBuffer b2 = ByteBuffer.allocateDirect(1024);
    }
}
