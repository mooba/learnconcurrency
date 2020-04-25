package site.pengcheng.designpattern.factory;

/**
 * @author pengchengbai
 * @description
 * @date 2020/4/22 5:39 下午
 */
public class RuleConfigSource {
    public RuleConfig load(String ruleConfigFilePath) throws Exception{
        String fileExt = getFileExtension(ruleConfigFilePath);
        IRuleConfigParser parser = SimpleRuleConfigParserFactory1.createParser(fileExt);

        // 从文件中获取configText
        String configText = "";
        return parser.parse(configText);
    }

    private String getFileExtension(String filePath) {
        // TODO 解析文件名获取扩展名，比如rule.json，返回json
        return "json";
    }
}
