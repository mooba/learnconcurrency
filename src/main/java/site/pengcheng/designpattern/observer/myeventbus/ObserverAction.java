package site.pengcheng.designpattern.observer.myeventbus;

import com.google.common.base.Preconditions;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author pengchengbai
 * @description 用来表示@Subscribe 注解的方法
 * @date 2020/9/5 7:32 下午
 */
public class ObserverAction {
    /**
     * 表示 观察者 类
     */
    private Object target;

    /**
     * 表示观察者用来响应消息的方法
     */
    private Method method;

    public ObserverAction(Object target, Method method) {
        Preconditions.checkNotNull(target);
        this.target = target;
        this.method = method;
        this.method.setAccessible(true);
    }


    /**
     * 对消息进行响应
     * @param event 表示消息
     */
    public void  execute(Object event) {
        try {
            method.invoke(target, event);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
