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
 * 虚引用：管理堆外内存
 * 堆外内存不归gc管，也就是不归jvm管，但是归Hotspot的c++程序管
 * 原来在读取外部文件的时候需要走os内核，然后到操作系统管理的内存，然后再被拷贝到jvm管理的内存中，这个过程很慢
 * 所以现在可以用一个jvm中的引用直接指向堆外的内存，减少数据拷贝，这技术称为zero copy
 * 为了解决管理堆外内存，这种引用对象被回收了，jvm得有办法把它指向的堆外内存清理掉
 * 具体过程就是，指向堆外内存的"直接引用"（比如DirectByteBuffer）被回收的时候虚引用会一个队列中发送一个"消息"
 * （也就是代码中初始化虚引用的时候为什么要用到一个队列的原因），
 * 告诉jvm直接饮用对象被回收了，那么它指向的堆外内存是不是也要处理一下呀
 *
 * 这个对象需要有个钩子机制来告诉jvm去清理堆外内存
 * 虚引用就是提供这种钩子机制
 *
 * 设置-Xmx20M
 * @date 2020/5/25 8:37 下午
 */
public class PhantomReferenceTest {
    private static final List<Object> LIST = new LinkedList<>();
    private static final ReferenceQueue<M> QUEUE = new ReferenceQueue<>();

    public static void main(String[] args) {
        PhantomReference<M> phantomReference = new PhantomReference<>(new M(), QUEUE);
        System.out.println(phantomReference.get());

        new Thread(() -> {
            while (true) {
                LIST.add(new byte[1014 * 1024 * 1]);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
                System.out.println(phantomReference.get());
            }
        }).start();

        // 模拟监控线程，监控对象是否被会后
        new Thread(() -> {
            while (true) {
                Reference<? extends M> poll = QUEUE.poll();
                if (poll != null) {
                    System.out.println("虚引用被jvm回收了" + poll);
                }
            }
        }).start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }




    // 虚引用的应用
    private void testNio() {
        ByteBuffer b1 = ByteBuffer.allocate(1014);

        // 这个就是在堆外直接分配
        ByteBuffer b2 = ByteBuffer.allocateDirect(1024);
    }
}
