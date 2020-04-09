package site.pengcheng.designpattern;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author pengchengbai
 * @description
 * @date 2020/4/8 6:03 下午
 */
public class HashMapTest {
    public static void main(String[] args) throws Exception {
        Map<String, Integer> map = new ConcurrentHashMap<>();

        String key = "foo";
        map.put(key, 1);


        Thread t1 = new Thread(
                () -> {
                    for (int i = 0; i < 100000; i++) {
                        map.computeIfPresent(key, (k, value) -> ++value);
//                        map.put(key, 1 + map.get(key));
                    }
                    System.out.println("t1 done");
                }
        );

        Thread t2 = new Thread(
                () -> {
                    for (int i = 0; i < 100000; i++) {
                        map.computeIfPresent(key, (k, value) -> ++value);
//                        map.put(key, 1 + map.get(key));
                    }
                    System.out.println("t2 done");
                }
        );

        t1.start();
        t2.start();

        Thread.sleep(5000);
        System.out.println(map.get(key));
    }
}