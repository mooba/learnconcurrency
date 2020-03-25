package site.pengcheng.learngeneric;

/**
 * @author pengchengbai
 * @description
 * @date 2020/3/14 2:20 下午
 */
public class Tuple {
    public static <A, B> TwoTuple<A, B> twoTuple(A a, B b) {
        return new TwoTuple<>(a, b);
    }

    public static <A, B, C> ThreeTuple<A, B, C> threeTuple(A a, B b, C c) {
        return new ThreeTuple<>(a, b, c);
    }
}
