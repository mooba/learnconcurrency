package site.pengcheng.designpattern.interpreter;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author pengchengbai
 * @description 基于解释器模式的规则引擎
 * 假设自定义的告警规则只包含“||、&&、>、<、==”这五个运算符，
 * 其中，“>、<、==”运算符的优先级高于“||、&&”运算符，“&&”运算符优先级高于“||”。
 * 在表达式中，任意元素之间需要通过空格来分隔
 * @date 2020/9/5 11:57 下午
 */

public class AlertRuleInterpreter {
    private Expression expression;

    /**
     * case1: key1 > 100 && key2 < 1000
     * case2: key1 > 100 && key2 < 1000 || key3 == 200
     */
    public AlertRuleInterpreter(String ruleExpression) {
        expression = new OrExpression(ruleExpression);
    }

    public AlertRuleInterpreter(Expression expression) {
        this.expression = expression;
    }

    // <String, Long> apiStat = new HashMap<>();
    // apiStat.put("key1", 103);
    // apiStat.put("key2", 987);
    public boolean interpret(Map<String, Long> stats) {
        return expression.interpret(stats);
    }

}

