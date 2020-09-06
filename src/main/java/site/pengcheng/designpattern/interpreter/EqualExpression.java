package site.pengcheng.designpattern.interpreter;

import java.util.Map;

/**
 * @author pengchengbai
 * @description
 * @date 2020/9/6 11:19 上午
 */
public class EqualExpression implements Expression{
    private String leftValue;
    private Long threshold;

    public EqualExpression(String leftValue, Long threshold) {
        this.leftValue = leftValue;
        this.threshold = threshold;
    }

    public EqualExpression(String expression) {
        String[] elements = expression.trim().split(" ");
        if (elements.length != 3 || elements[1] == null || !"==".equals(elements[1])) {
            throw new RuntimeException("Expression is invalid: " + expression);
        }
        this.leftValue = elements[0];
        this.threshold = Long.valueOf(elements[2]);
    }

    @Override
    public boolean interpret(Map<String, Long> stat) {
        Long value = stat.get(leftValue);
        if (value == null) {
            return false;
        }
        return value.equals(threshold);
    }
}
