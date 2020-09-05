package site.pengcheng.designpattern.observer.myeventbus;

import com.google.common.util.concurrent.MoreExecutors;

import java.util.List;
import java.util.concurrent.Executor;

/**
 * @author pengchengbai
 * @description event bus
 * @date 2020/9/5 6:57 下午
 */
public class EventBus {
    private ObserverRegistry registry = new ObserverRegistry();
    private Executor executor;

    public EventBus() {
        this(MoreExecutors.directExecutor());
    }

    protected EventBus(Executor executor) {
        this.executor = executor;
    }

    public void register(Object observer) {
        registry.register(observer);
    }

    public void post(Object event) {
        List<ObserverAction> matchedObserverAction = registry.getMatchedObserverAction(event);

        for (ObserverAction observerAction : matchedObserverAction) {
            executor.execute(() -> {
                observerAction.execute(event);
            });
        }
    }
}
