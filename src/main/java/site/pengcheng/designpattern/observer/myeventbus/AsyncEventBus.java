package site.pengcheng.designpattern.observer.myeventbus;

import java.util.concurrent.Executor;

/**
 * @author pengchengbai
 * @description asyn event bus
 * @date 2020/9/5 6:57 下午
 */
public class AsyncEventBus extends EventBus{
    public AsyncEventBus(Executor executor) {
        super(executor);
    }
}
