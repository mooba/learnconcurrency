package site.pengcheng.designpattern.interpreter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author pengchengbai
 * @description
 * @date 2020/9/6 11:21 上午
 */
public class OrExpression implements Expression{
    private List<Expression> expressions = new ArrayList<>();

    public OrExpression(String expression) {
        String[] elements = expression.trim().split("\\|\\|");
        for (String element : elements) {
            expressions.add(new AndExpression(element));
        }
    }

    public OrExpression(List<Expression> expressions) {
        this.expressions.addAll(expressions);
    }

    @Override
    public boolean interpret(Map<String, Long> stat) {
        for (Expression expression : expressions) {
            if (expression.interpret(stat)) {
                return true;
            }
        }
        return false;
    }
}
