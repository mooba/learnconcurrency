package site.pengcheng.learngeneric;

/**
 * @author pengchengbai
 * @description
 * @date 2020/3/8 3:54 下午
 */
public class GenericMethod {
    private <T> void f(T x) {
        System.out.println(x.getClass().getName());
    }
    
    public static void main(String[] args) {
        GenericMethod gen = new GenericMethod();
        gen.f(10L);
        gen.f(1.0);

    }
}
