package site.pengcheng.designpattern.observer.myeventbus;

import com.google.common.base.Preconditions;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author pengchengbai
 * @description 用于保存消息和响应消息的方法的映射关系
 * @date 2020/9/5 7:36 下午
 */
public class ObserverRegistry {
    private Map<Class<?>, CopyOnWriteArraySet<ObserverAction>> registry = new ConcurrentHashMap<>();

    public void register(Object observer) {
        Map<Class<?>, Collection<ObserverAction>> observerActions = findAllObserverActions(observer);
        for (Map.Entry<Class<?>, Collection<ObserverAction>> entry : observerActions.entrySet()) {
            Class<?> eventType = entry.getKey();
            Collection<ObserverAction> observerActionCollection = entry.getValue();
            CopyOnWriteArraySet<ObserverAction> observerActionsSet = registry.get(eventType);
            if (observerActionsSet == null) {
                registry.put(eventType, new CopyOnWriteArraySet<>());
                observerActionsSet = registry.get(eventType);
            }
            observerActionsSet.addAll(observerActionCollection);
        }
    }


    /**
     * 根据消息的类型返回对应的ObserverAction
     * @param event 消息
     * @return
     */
    public List<ObserverAction> getMatchedObserverAction(Object event) {
        List<ObserverAction> observerActions = new ArrayList<>();
        Class<?> postedEventType = event.getClass();
        for (Map.Entry<Class<?>, CopyOnWriteArraySet<ObserverAction>> entry : registry.entrySet()) {
            Class<?> eventType = entry.getKey();
            Collection<ObserverAction> observerActionsSet = entry.getValue();
            if (eventType.isAssignableFrom(postedEventType)) {
                observerActions.addAll(observerActionsSet);
            }
        }
        return observerActions;
    }


    private Map<Class<?>, Collection<ObserverAction>> findAllObserverActions(Object observer) {
        Map<Class<?>, Collection<ObserverAction>> observerActions = new HashMap<>(8);
        Class<?> observerClazz = observer.getClass();
        for (Method method : getAnnotatedMethods(observerClazz)) {
            Class<?> eventType = method.getParameterTypes()[0];
            ObserverAction observerAction = new ObserverAction(observer, method);
            if (!observerActions.containsKey(eventType)) {
                observerActions.put(eventType, new ArrayList<>());
            }
            observerActions.get(eventType).add(observerAction);
        }

        return observerActions;
    }


    private List<Method> getAnnotatedMethods(Class<?> clazz) {
        List<Method> methods = new ArrayList<>();
        // 获取类的所有方法，包括private的和继承的
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method method : declaredMethods) {
            if (method.isAnnotationPresent(Subscribe.class)) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                Preconditions.checkArgument(parameterTypes.length == 1,
                        "Method %s has @Subscribe annotation but has %s parameters."
                                + "Subscriber methods must have exactly 1 parameter.",
                        method, parameterTypes.length);
                methods.add(method);
            }
        }
        return methods;
    }
}
