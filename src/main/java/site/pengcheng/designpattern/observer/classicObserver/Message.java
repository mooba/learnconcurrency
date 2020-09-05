package site.pengcheng.designpattern.observer.classicObserver;

/**
 * @author pengchengbai
 * @description msg that will send to observer
 * @date 2020/9/5 7:04 下午
 */
public class Message {

    @Override
    public String toString() {
        return "Hello, this is message" + this.hashCode();
    }
}
