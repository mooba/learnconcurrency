package site.pengcheng.designpattern.factory;

/**
 * @author pengchengbai
 * @description 这种方式实现的简单工厂每次都返回新的对象
 * @date 2020/4/22 5:35 下午
 */
public class SimpleRuleConfigParserFactory1 {
    public static IRuleConfigParser createParser(String configFormat) throws Exception{
        IRuleConfigParser parser = null;
        if ("json".equals(configFormat)) {
            parser = new JsonRuleConfigParser();
        } else if ("xml".equals(configFormat)) {
            parser = new XmlRuleConfigParser();
        } else if ("yaml".equals(configFormat)) {
            parser = new YamlRuleConfigParser();
        } else if ("properties".equals(configFormat)) {
            parser = new PropertiesRuleConfigParser();
        } else {
            throw new Exception("Rule config file format is not supported: " +  configFormat);
        }
        return parser;
    }
}
