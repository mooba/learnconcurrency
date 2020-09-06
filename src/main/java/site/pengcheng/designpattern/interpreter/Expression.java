package site.pengcheng.designpattern.interpreter;

import java.util.Map;

/**
 * @author pengchengbai
 * @description
 * @date 2020/9/6 11:14 上午
 */
public interface Expression {
    boolean interpret(Map<String, Long> stat);
}
