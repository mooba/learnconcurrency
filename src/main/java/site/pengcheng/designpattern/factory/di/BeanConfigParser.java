package site.pengcheng.designpattern.factory.di;

import java.io.InputStream;
import java.util.List;

public interface BeanConfigParser {
    List<BeanDefinition> parse(String configLocation);
    List<BeanDefinition> parse(InputStream inputStream);
}
