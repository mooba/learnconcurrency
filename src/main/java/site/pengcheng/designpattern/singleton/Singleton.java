package site.pengcheng.designpattern.singleton;

/**
 * @author pengchengbai
 * @description
 * @date 2020/4/12 5:01 下午
 */

public class Singleton {
    private static Singleton instance = null;
    private final int paramA;
    private final int paramB;

    private Singleton(int paramA, int paramB) {
        this.paramA = paramA;
        this.paramB = paramB;
    }

    public synchronized static Singleton getInstance(int paramA, int paramB) {
        if (instance == null) {
            instance = new Singleton(paramA, paramB);
        }
        return instance;
    }

    public void printParam() {
        System.out.println(paramA + ":" + paramB);
    }

    public void setInstanceNull() {
        instance = null;
    }
}
