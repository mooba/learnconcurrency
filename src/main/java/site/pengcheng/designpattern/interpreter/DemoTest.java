package site.pengcheng.designpattern.interpreter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pengchengbai
 * @description
 * @date 2020/9/5 11:58 下午
 */
public class DemoTest {
    public static void main(String[] args) {
        String rule = "key1 > 100 && key2 < 30 || key3 < 100 || key4 == 88";
        AlertRuleInterpreter interpreter = new AlertRuleInterpreter(rule);
        Map<String, Long> stats = new HashMap<>(8);
        stats.put("key1", 101L);
        stats.put("key3", 121L);
        stats.put("key4", 89L);
        boolean alert = interpreter.interpret(stats);
        System.out.println(alert);
    }
}
