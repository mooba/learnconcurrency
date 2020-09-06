package site.pengcheng.designpattern.interpreter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author pengchengbai
 * @description
 * @date 2020/9/6 11:22 上午
 */
public class AndExpression implements Expression{
    private List<Expression> expressions = new ArrayList<>();

    public AndExpression(String expression) {
        String[] elements = expression.trim().split("&&");
        for (String element : elements) {
            if (element.contains(">")) {
                expressions.add(new BiggerThanExpression(element.trim()));
            } else if (element.contains("<")) {
                expressions.add(new LessThanExpression(element.trim()));
            } else if (element.contains("==")) {
                expressions.add(new EqualExpression(element));
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    @Override
    public boolean interpret(Map<String, Long> stat) {
        for (Expression expression : expressions) {
            if (!expression.interpret(stat)) {
                return false;
            }
        }
        return true;
    }
}
