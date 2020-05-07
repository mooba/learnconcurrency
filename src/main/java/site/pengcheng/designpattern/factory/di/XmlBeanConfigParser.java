package site.pengcheng.designpattern.factory.di;

import java.io.InputStream;
import java.util.List;

/**
 * @author pengchengbai
 * @description
 * @date 2020/4/25 5:02 下午
 */
public class XmlBeanConfigParser implements BeanConfigParser{

    @Override
    public List<BeanDefinition> parse(String configLocation) {
        return null;
    }


    @Override
    public List<BeanDefinition> parse(InputStream inputStream) {
        return null;
    }
}
