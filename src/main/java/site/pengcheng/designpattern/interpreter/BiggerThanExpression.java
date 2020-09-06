package site.pengcheng.designpattern.interpreter;

import java.util.Map;

/**
 * @author pengchengbai
 * @description
 * @date 2020/9/6 11:09 上午
 */
public class BiggerThanExpression implements Expression{
    private String key;
    private long threshold;

    public BiggerThanExpression(String expression) {
        String[] elements = expression.trim().split(" ");
        if (3 != elements.length || !">".equals(elements[1])) {
            throw new RuntimeException("Expression is invalid: " + expression);
        }
        this.key = elements[0];
        this.threshold = Long.valueOf(elements[2]);
    }

    public BiggerThanExpression(String key, Integer threshold) {
        this.key = key;
        this.threshold = threshold;
    }

    @Override
    public boolean interpret(Map<String, Long> stat) {
        Long value = stat.get(key);
        if (value == null) {
            return false;
        }
        return value > threshold;
    }
}
