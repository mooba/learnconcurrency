package site.pengcheng.functional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author pengchengbai
 * @description  创建流的各种方式
 * @date 2020/6/27 1:52 下午
 */
public class StreamDemo {
    public static void main(String[] args) {
        // 从集合创建
        List<Integer> list = new ArrayList<>();
        list.stream();

        // 从数组创建
        Arrays.stream(new int[]{1, 3, 5}).forEach(System.out::println);

        // 创建数字流
        IntStream.of(1, 3, 5).forEach(System.out::println);
        IntStream.range(1, 10).forEach(System.out::println);


        //使用random创建无限流
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);


        // 自己产生流
        Stream.generate(() -> random.nextInt()).limit(20).forEach(System.out::println);
    }
}
