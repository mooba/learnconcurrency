package site.pengcheng.functional;

import java.util.function.Function;

/**
 * @author pengchengbai
 * @description 级联表达式和柯里化
 * 柯里化：把多个参数的函数转化成只有一个参数的函数
 * 目的：函数标准化
 * 高阶函数：返回函数的函数
 * @date 2020/6/27 1:34 下午
 */
public class CurryDemo {
    
    public static void main(String[] args) {
        Function<Integer, Function<Integer, Integer>> function = x -> y -> x + y;
        System.out.println(function.apply(2).apply(3));


        // 实现add(2)(3)(4)这种函数调用方式
        Function<Integer, Function<Integer, Function<Integer, Integer>>> function1 = x -> y -> z -> x + y + z;
        System.out.println(function1.apply(2).apply(3).apply(4));
    }
}
