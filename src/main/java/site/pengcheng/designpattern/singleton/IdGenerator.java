package site.pengcheng.designpattern.singleton;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author pengchengbai
 * @description 唯一递增id生成器
 * @date 2020/4/12 4:46 下午
 */
public class IdGenerator {
    private static final IdGenerator INSTANCE = new IdGenerator();
    AtomicInteger count = new AtomicInteger(0);
    private IdGenerator() {
    }

    public static IdGenerator getInstance() {
        return INSTANCE;
    }

    public int getId() {
        return count.incrementAndGet();
    }
}
