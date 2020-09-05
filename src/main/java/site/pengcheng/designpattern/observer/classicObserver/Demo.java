package site.pengcheng.designpattern.observer.classicObserver;

/**
 * @author pengchengbai
 * @description 入口类
 * @date 2020/9/5 7:13 下午
 */
public class Demo {
    public static void main(String[] args) {
        Subject subject = new ConcreteSubject();
        subject.registerObserver(new ConcreteObserverOne());
        subject.registerObserver(new ConcreteObserverTwo());
        subject.notifyObserver(new Message());
    }
}
