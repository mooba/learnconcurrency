package site.pengcheng.designpattern.observer.classicObserver;

/**
 * @author pengchengbai
 * @description
 * @date 2020/9/5 7:08 下午
 */
public class ConcreteObserverOne implements Observer{
    @Override
    public void update(Message message) {
        //TODO: 获取消息通知，执行自己的逻辑...
        System.out.println("ConcreteObserverOne is notified by message:" + message);
    }
}
