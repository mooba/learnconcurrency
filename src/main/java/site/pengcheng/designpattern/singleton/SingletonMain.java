package site.pengcheng.designpattern.singleton;

/**
 * @author pengchengbai
 * @description
 * @date 2020/4/12 4:52 下午
 */
public class SingletonMain {
    public static void main(String[] args) {
//        IdGenerator idGenerator = IdGenerator.getInstance();

        Singleton singleton = Singleton.getInstance(10, 50);
        singleton.printParam();

        singleton.setInstanceNull();
        Singleton singleton1 = Singleton.getInstance(20, 30);
        singleton1.printParam();

    }
}
