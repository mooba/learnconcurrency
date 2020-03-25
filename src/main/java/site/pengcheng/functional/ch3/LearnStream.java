package site.pengcheng.functional.ch3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.awt.event.ActionEvent;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author pengchengbai
 * @description
 * @date 2020/1/18 11:31 上午
 */
public class LearnStream {
    public static void main(String[] args) {
//        List<String> strings = Stream.of("a", "be", "hello").collect(Collectors.toList());
//        strings = strings.stream().map(string -> string.toUpperCase()).collect(Collectors.toList());
//        strings = strings.stream().filter(s -> s.contains("e")).collect(Collectors.toList());
//
//        System.out.println(strings);
//
//        List<Integer> integerList = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4))
//                .flatMap(numbers -> numbers.stream()).collect(Collectors.toList());
//
//        System.out.println(integerList);
//
//
//        simulationReduce();
//        mapToLongTest();
//
//        Optional emptyOptional = Optional.empty();
//        System.out.println(emptyOptional.isPresent());

//        forEachTest();

//        joinString();

//        parallelStreamTest();

        System.out.println(parallelDiceRolls());

//        Map<Integer, List<Integer>> ret = IntStream.range(1, 100)
//                .parallel()
//                .mapToObj(x -> twoDiceThrows())
//                .collect(Collectors.groupingBy(side -> side));

//        System.out.println(ret);
    }

    private static ThreadLocalRandom random = ThreadLocalRandom.current();


    private static void findShortestSong() {
        List<Track> tracks = Arrays.asList(new Track("Bakai", 524),
                new Track("Violets for Your Furs", 378),
                new Track("Time Was", 451)
        );

        Track track1 = tracks.stream().min((x, y) -> x.getLength() - y.getLength()).get();
        System.out.println(track1);

        tracks.stream().min(Comparator.comparing(Track::getLength));
    }


    @AllArgsConstructor
    @Getter
    @ToString
    static class Track {
        String name;
        int length;
    }

    private static void simulationReduce() {
        BinaryOperator<Integer> accumulator = (x, y) -> x + y;
        int account = accumulator.apply(accumulator.apply(accumulator.apply(0, 1), 2), 3);
        System.out.println(account);
    }


    private static void mapToLongTest() {
        long start = System.currentTimeMillis();
        System.out.println(Stream.iterate(0, i -> i + 2).limit(1000000).mapToLong(i -> i).reduce(0, (acc, item) -> acc + item));
        System.out.println(System.currentTimeMillis() - start);

        long start2 = System.currentTimeMillis();
        System.out.println(Stream.iterate(0, i -> i + 2).limit(1000000).mapToLong(i -> i).boxed().reduce(0L, (acc, item) -> acc + item));
        System.out.println(System.currentTimeMillis() - start2);

    }


    private static void forEachTest() {
//        Stream.iterate(0, i -> i + 2).limit(10).forEachOrdered(System.out::println);
        long start = System.currentTimeMillis();
        Stream.iterate(0, i -> i + 2).limit(100).parallel().forEach(System.out::println);
        long end1 = System.currentTimeMillis();
        Stream.iterate(0, i -> i + 2).limit(100).parallel().forEachOrdered(System.out::println);
        long end2 = System.currentTimeMillis();

        System.out.println("duration1:" + (end1 - start) + " duration2:" + (end2 - end1));
    }


    private static void joinString() {
        List<String> stringList = Arrays.asList("bai", "peng", "cheng", "chenglong", "wang", "yi");
        System.out.println(String.join(",", stringList));
        System.out.println(stringList.stream().collect(Collectors.joining()));
        System.out.println(stringList.stream().collect(Collectors.joining(",", "[", "]")));

        // 数据分组
        Map<String, List<String>> stringListMap = stringList.stream()
                .collect(Collectors.groupingBy(str -> str.substring(str.length() - 1)));
        System.out.println(stringListMap);

        // 数据分区
        Map<Boolean, List<String>> stringListMap2 = stringList.stream()
                .collect(Collectors.partitioningBy(str -> str.endsWith("g")));
        System.out.println(stringListMap2);


        // 分组后计算每个组的数量(组合收集器)
        Map<String, Long> stringListMap3 = stringList.stream()
                .collect(Collectors.groupingBy(str -> str.substring(str.length() - 1), Collectors.counting()));
        System.out.println(stringListMap3);

        Map<String, List<String>> stringListMap5 = stringList.stream()
                .collect(Collectors.groupingBy(str -> str.substring(str.length() - 1),
                        Collectors.mapping(String::toUpperCase, Collectors.toList())));


        // 自定义收集器
        System.out.println(stringList.stream().collect(Collectors.joining(",")));
        StringBuilder reduced = stringList.stream().reduce(new StringBuilder(), (builder, name) -> {
                if (builder.length() > 0) {
                    builder.append(", ");
                }
                builder.append(name);
                return builder;
            }, (left, right) -> left.append(right));

        reduced.insert(0, "[").append("]");
        System.out.println(reduced.toString());
    }


    private static void parallelStreamTest() {
        double N = 100000;
//        List<Integer> list = IntStream.range(1, N).

    }

    private static int twoDiceThrows() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int firstThrow = random.nextInt(1, 7);
        int secondThrow = random.nextInt(1, 7);
        return firstThrow + secondThrow;
    }

    public static Map<Integer, Double> parallelDiceRolls() {
        int N = 1000;
        double fraction = 1.0 / N;
        Map<Integer, Double> ret = IntStream.range(1, N)
                .parallel()
                .mapToObj(x -> twoDiceThrows())
                .collect(Collectors.groupingBy(side -> side,
                        Collectors.summingDouble(n -> fraction)));

        return ret;
    }


}
