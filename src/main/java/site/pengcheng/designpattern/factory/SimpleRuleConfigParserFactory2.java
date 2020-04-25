package site.pengcheng.designpattern.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pengchengbai
 * @description 这种简单工厂的实现方式每次都返回相同的对象，也就是单例对象
 * @date 2020/4/22 5:53 下午
 */
public class SimpleRuleConfigParserFactory2 {
    private static Map<String, IRuleConfigParser> factoryMap = new HashMap<>(8);
    static {
        factoryMap.put("json", new JsonRuleConfigParser());
        factoryMap.put("xml", new XmlRuleConfigParser());
        factoryMap.put("yaml", new JsonRuleConfigParser());
        factoryMap.put("properties", new PropertiesRuleConfigParser());
    }

    public static IRuleConfigParser createParser(String configFormat) {
        return factoryMap.getOrDefault(configFormat, null);
    }
    
    public static void main(String[] args) {
        Map<String, Integer> factoryMap = new HashMap<>(8);
        factoryMap.put(null, 34);
        System.out.println(factoryMap.get(null));
    }
}
