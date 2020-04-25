package site.pengcheng.designpattern.factory;

/**
 * @author pengchengbai
 * @description 用于工厂方法模式
 * @date 2020/4/22 6:29 下午
 */
public class RuleConfigSource2 {
    public RuleConfig load(String ruleConfigFilePath) throws Exception{
        String fileExt = getFileExtension(ruleConfigFilePath);

        IRuleConfigParser parser = null;
        IRuleConfigParserFactory factory = RuleConfigParserFactoryMap.createFactory(fileExt);
        if (factory != null) {
            parser = factory.createParser();
        }

        // 从文件中获取configText
        String configText = "";
        return parser.parse(configText);
    }

    private String getFileExtension(String filePath) {
        // TODO 解析文件名获取扩展名，比如rule.json，返回json
        return "json";
    }
}
