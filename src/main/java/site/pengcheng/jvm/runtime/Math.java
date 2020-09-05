package site.pengcheng.jvm.runtime;

/**
 * @author pengchengbai
 * @description
 * @date 2020/8/9 11:07 下午
 */
public class Math {
    private static final int initData = 666;

    // 一个方法对应一个栈帧内存区域
    public int compute() {
        int a = 1;
        int b = 2;
        int c = (a + b) * 10;
        return c;
    }

    public static void main(String[] args) {
        Math math = new Math();
        int ret = math.compute();
        System.out.println("result:" + ret);
    }

}
