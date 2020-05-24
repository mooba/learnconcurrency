package site.pengcheng.concurrent.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author pengchengbai
 * @description
 * @date 2020/5/17 4:44 下午
 */
@Slf4j
public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread("") {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {

                }
            }
        };

        log.info("state:" + t.getState());
        t.start();
        log.info("state:" + t.getState());
        t.join();
        log.info("state:" + t.getState());

    }
}
