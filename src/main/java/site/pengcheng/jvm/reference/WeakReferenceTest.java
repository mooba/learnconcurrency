package site.pengcheng.jvm.reference;


import java.lang.ref.WeakReference;

/**
 * @author pengchengbai
 * @description
 * 弱引用在gc的时候直接回收
 * 这是重点，和ThreadLocal相关
 * @date 2020/5/25 8:32 下午
 */
public class WeakReferenceTest {
    public static void main(String[] args) {
        WeakReference<M> m = new WeakReference<>(new M());
        System.out.println(m.get());
        System.gc();
        System.out.println(m.get());
    }
}
