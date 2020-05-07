package site.pengcheng.designpattern.prototype;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author pengchengbai
 * @description
 * 如果对象的创建成本比较大，而同一个类的不同对象之间差别不大（大部分字段都相同），
 * 在这种情况下，我们可以利用对已有对象（原型）进行复制（或者叫拷贝）的方式，来创建新对象，
 * 以达到节省创建时间的目的。这种基于原型来创建对象的方式就叫作原型设计模式
 *
 * java Object 类中的clone() 方法执行的就是"浅拷贝"，只会拷贝基本数据类型和引用的内存地址
 *
 * 没有充分的理由，不要为了一点点的性能提升而使用浅拷贝
 * @date 2020/5/7 8:50 下午
 */
public class PrototypeDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> clone = (HashMap<String, Integer>)map.clone();
    }
}
