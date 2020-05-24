package site.pengcheng.concurrent.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * @author pengchengbai
 * @description
 * @date 2020/5/17 4:15 下午
 */
@Slf4j(topic = "c.Test4")
public class Test4 {

    public static void main(String[] args) {
        Thread thread = new Thread("t1") {
            @Override
            public void run() {
                log.info("running");
            }
        };

        thread.run();
        log.info("do other things");
    }
}
