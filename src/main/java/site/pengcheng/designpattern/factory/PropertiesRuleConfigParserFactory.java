package site.pengcheng.designpattern.factory;

/**
 * @author pengchengbai
 * @description
 * @date 2020/4/22 6:15 下午
 */
public class PropertiesRuleConfigParserFactory implements IRuleConfigParserFactory {
    @Override
    public IRuleConfigParser createParser() {
        return new PropertiesRuleConfigParser();
    }
}
