package site.pengcheng.learngeneric;



/**
 * @author pengchengbai
 * @description
 * @date 2020/3/14 2:04 下午
 */
public class ThreeTuple<A, B, C> extends TwoTuple<A, B>{
    public final C third;

    public ThreeTuple(A first, B second, C third) {
        super(first, second);
        this.third = third;
    }

    @Override
    public String toString() {
        return "(" + third + "," + first + "," + second + ')';
    }
}
