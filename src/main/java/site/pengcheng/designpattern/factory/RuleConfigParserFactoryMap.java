package site.pengcheng.designpattern.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pengchengbai
 * @description 工厂的工厂，用于 工厂方法 模式
 * @date 2020/4/22 6:20 下午 gong
 */
public class RuleConfigParserFactoryMap {
    private static Map<String, IRuleConfigParserFactory> factoryMap = new HashMap<>(16);

    static {
        factoryMap.put("json", new JsonRuleConfigParserFactory());
        factoryMap.put("xml", new XmlRuleConfigParserFactory());
        factoryMap.put("yaml", new YamlRuleConfigParserFactory());
        factoryMap.put("properties", new PropertiesRuleConfigParserFactory());
    }

    public static IRuleConfigParserFactory createFactory(String configFormat) {
        return factoryMap.getOrDefault(configFormat, null);
    }

}
