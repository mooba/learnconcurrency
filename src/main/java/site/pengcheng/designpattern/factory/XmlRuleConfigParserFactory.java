package site.pengcheng.designpattern.factory;

/**
 * @author pengchengbai
 * @description
 * @date 2020/4/22 6:14 下午
 */
public class XmlRuleConfigParserFactory implements IRuleConfigParserFactory {
    @Override
    public IRuleConfigParser createParser() {
        return new XmlRuleConfigParser();
    }
}
