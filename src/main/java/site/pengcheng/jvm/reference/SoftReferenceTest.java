package site.pengcheng.jvm.reference;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.lang.ref.SoftReference;

/**
 * @author pengchengbai
 * @description 当空间不够了，软引用对象会被回收 使用-Xmx20M参数可以复现这个这种回收
 * 软引用非常适合缓存使用
 * @date 2020/5/25 8:21 下午
 */
public class SoftReferenceTest {
    public static void main(String[] args) {
        // 10M
        SoftReference<byte[]> m = new SoftReference<>(new byte[1024 * 1024 * 10]);
        System.out.println(m.get());

        System.gc();

        //给gc一点回收时间
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(m.get());

        // 再分配一个强引用数组，15M，heap将装不下，这时候系统会垃圾回收，先回收一次，如果不够，会把软引用干掉
        byte[] b = new byte[1024 * 1024 * 10];

        // 使用参数-Xmx20M运行该demo这里打印null
        System.out.println(m.get());
    }

    private void testGuava() {
        CacheLoader<String, String> loader = new CacheLoader<String, String>() {
            @Override
            public String load(String key) {
                return key.toUpperCase();
            }
        };

        LoadingCache<String, String> cache;
        cache = CacheBuilder.newBuilder().softValues().build(loader);

    }
}
