package site.pengcheng.designpattern.observer.classicObserver;

/**
 * @author pengchengbai
 * @description
 * @date 2020/9/5 7:08 下午
 */
public class ConcreteObserverTwo implements Observer{
    @Override
    public void update(Message message) {
        // TODO 获取通知执行自己的逻辑
        System.out.println("ConcreteObserverTwo is notified by message:" + message);
    }
}
