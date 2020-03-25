package site.pengcheng.learngeneric;

/**
 * @author pengchengbai
 * @description
 * @date 2020/3/14 2:04 下午
 */
class TwoTuple<A, B> {
    public final A first;
    public final B second;

    public TwoTuple(A a, B b) {
        this.first = a;
        this.second = b;
    }

    @Override
    public String toString() {
        return "(" + first + "," + second + ")";
    }
}
