package site.pengcheng.designpattern.factory;

/**
 * @author pengchengbai
 * @description
 * @date 2020/4/22 6:13 下午
 */
public class JsonRuleConfigParserFactory implements IRuleConfigParserFactory{
    @Override
    public IRuleConfigParser createParser() {
        return new JsonRuleConfigParser();
    }
}
