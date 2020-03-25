package site.pengcheng.learngeneric;

/**
 * @author pengchengbai
 * @description
 * @date 2020/3/8 12:39 下午
 */
public class Coffee {
    private static long counter = 0;
    private final long id = counter ++;
    private String name;

    public Coffee() {
        name = "latte";
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }

    public static long getCounter() {
        return counter;
    }

    public long getId() {
        return id;
    }

    public static void main(String[] args) {
        Coffee c1 = new Cappuccion();
        Coffee c2 = new Latte();
        Coffee c3 = new Mocha();

        System.out.println(c3.getId());
        System.out.println(Coffee.getCounter());
    }
}
