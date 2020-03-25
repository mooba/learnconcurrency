package site.pengcheng.ch6;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author pengchengbai
 * @description
 * @date 2020/1/19 11:26 上午
 */
public class ParallelArray {
    public static void main(String[] args) {
//
//        double values[] = parallelInitialize(10);
//        System.out.println(simpleMovingAverage(values, 3));
//
//        values = simpleMovingAverage(values, 3);
//        for (int i = 0; i < values.length; i++) {
//            System.out.println(values[i]);
//        }

        testPeak();
    }

    public static double[] parallelInitialize(int size) {
        double[] values = new double[size];
        Arrays.parallelSetAll(values, i -> i);
        return values;
    }

    // 计算滑动平均数
    public static double[] simpleMovingAverage(double[] values, int n) {
        double[] sums = Arrays.copyOf(values, values.length);
        Arrays.parallelPrefix(sums, Double::sum);
        return sums;
    }


    public static void testPeak() {
        List<User> users = Arrays.asList(new User("Alice"), new User("Bob"), new User("Chuck"));
//        Stream<User> userStream = Stream.of(new User("Alice"), new User("Bob"), new User("Chuck"));
        Stream<User> userStream = users.stream();
        userStream.map(u -> {
            User user = new User();
            user.setName(u.getName().toLowerCase());
            return user;
        }).forEach(System.out::println);

//        userStream.peek(u -> u.setName(u.getName().toLowerCase()))
//                .forEach(System.out::println);

        users.forEach(System.out::println);
    }

    @Data
    @NoArgsConstructor
    static class User {
        private String name;
        private Integer age;

        public User(String name) {
            this.name = name;
        }
    }

}
