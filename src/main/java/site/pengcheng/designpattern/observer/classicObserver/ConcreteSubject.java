package site.pengcheng.designpattern.observer.classicObserver;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pengchengbai
 * @description
 * @date 2020/9/5 7:05 下午
 */
public class ConcreteSubject implements Subject{
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver(Message message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
