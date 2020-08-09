package site.pengcheng.jvm.reference;

/**
 * @author pengchengbai
 * @description
 * @date 2020/5/25 8:33 下午
 */
public class M {
    /**
     * 当对象回收之前，该方法会被调用。
     * 但是通常不推荐重写该方法，因为这个方法不知道什么时候会被调用，甚至不一定会被调用，不能依赖它去回收一些资源，
     * 所以现在已经过期了
     * @throws Throwable
     */
    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize");
    }
}
