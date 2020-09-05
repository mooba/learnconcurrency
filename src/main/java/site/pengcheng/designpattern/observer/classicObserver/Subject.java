package site.pengcheng.designpattern.observer.classicObserver;

/**
 * @author pengchengbai
 * @description 被观察者，Observable
 * @date 2020/9/5 7:01 下午
 */
public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObserver(Message message);
}
