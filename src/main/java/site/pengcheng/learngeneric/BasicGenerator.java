package site.pengcheng.learngeneric;

/**
 * @author pengchengbai
 * @description
 * @date 2020/3/8 4:17 下午
 */
public class BasicGenerator<T> implements Generator<T> {

    private Class<T> type;

    public BasicGenerator(Class type) {
        this.type = type;
    }



    @Override
    public T next() {
        try {
            return type.newInstance();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) {
        BasicGenerator gen = new BasicGenerator(Coffee.class);
        System.out.println(gen.next());
    }
}
