package site.pengcheng.guava;

import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.collect.*;
import site.pengcheng.learngeneric.Person;

import java.io.IOException;
import java.util.*;

/**
 * @author pengchengbai
 * @description
 * @date 2020/3/6 11:45 上午
 */
public class TestGuava {

    private static void testUnmodifiable() {
        List<Person> list = new ArrayList<>(16);
        list.add(new Person("bai", 23));
        list.add(new Person("coco", 24));

        // 事实上和list对应的是同一个对象，并且原list的变化会导致readOnlyList变化
        List<Person> readOnlyList = Collections.unmodifiableList(list);

        list.add(new Person("li", 34));
        System.out.println(readOnlyList.size());
        System.out.println(System.identityHashCode(list.get(0)));
        System.out.println(System.identityHashCode(readOnlyList.get(0)));

        // 使用"保护性拷贝" 获得不可变对象，原list的变化不影响它
        List<Person> readOnlyByCopy = Collections.unmodifiableList(new ArrayList<>(list));
        list.add(new Person("peng", 34));
        System.out.println(readOnlyByCopy.size());
        System.out.println(System.identityHashCode(readOnlyByCopy.get(0)));

    }


    private static void guavaImmutable() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        List<String> immutable = ImmutableList.of("a", "b", "c");
        System.out.println(System.identityHashCode(immutable));

        List<String> immutable2 = ImmutableList.copyOf(list);
        list.add("d");
        System.out.println(immutable2);
    }


    private static void testTable() {
        Table<String, String, Integer> table = HashBasedTable.create();
        table.put("zhangsan", "CS", 80);
        table.put("zhangsan", "math", 90);
        table.put("zhangsan", "yuwen", 90);

        Set<Table.Cell<String, String, Integer>> cellSet =  table.cellSet();
        for (Table.Cell<String, String, Integer> cell: cellSet) {
            Joiner joiner = Joiner.on("-").skipNulls();
            System.out.println(joiner.join(Arrays.asList(cell.getRowKey(), cell.getColumnKey(), cell.getValue())));
        }
    }

    public void givenStringBuilder_whenAppended_thenModified() {
        StringBuilder test = new StringBuilder();
        test.append("a");
        int firstAddressOfTest = System.identityHashCode(test);
        test.append("b");
        int secondAddressOfTest = System.identityHashCode(test);

        System.out.println(firstAddressOfTest != secondAddressOfTest);
    }

    private static void testPrecondition() {
        int[] numbers = { 1, 2, 3, 4, 5 };
        String message = "Please check the bound of an array and retry";
        Preconditions.checkElementIndex(6, numbers.length - 1, message);
    }


    private static void testNull() {
        List<String> list = Lists.newArrayList("bai", "peng", null, "cheng");
        System.out.println(list.size());
        Map<String, String> map = new HashMap<>();
        map.put(null,"hello");
        map.put(null, "hi");
        System.out.println(map.get(null));

        Optional<Person> op = Optional.of(new Person("allan", 10));

        if (op.isPresent()) {
            System.out.println(op.get());
        }
    }

    private static void testSplitter() {

    }



    public static void main(String[] args) throws IOException{


    }
}
