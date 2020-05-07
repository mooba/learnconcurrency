package site.pengcheng.designpattern.factory.di;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author pengchengbai
 * @description
 * @date 2020/4/25 5:02 下午
 */
@Slf4j
public class ClassPathXmlApplicationContext implements ApplicationContext{
    private BeanFactory beanFactory;
    private BeanConfigParser beanConfigParser;

    public ClassPathXmlApplicationContext(String configLocation) {
        this.beanFactory = new BeanFactory();
        this.beanConfigParser = new XmlBeanConfigParser();
        loadBeanDefinitions(configLocation);
    }

    private void loadBeanDefinitions(String configLocation) {
//        InputStream in = null;
//        try {
//            in = this.getClass().getResourceAsStream("/" + configLocation);
//            if (in == null) {
//                throw new RuntimeException("cannot find config file: " + configLocation);
//            }
//            List<BeanDefinition> beanDefinitions = beanConfigParser.parse(in);
//            beanFactory.add(beanDefinitions);
//        } finally {
//            if (in != null) {
//                try {
//                    in.close();
//                } catch (IOException ioe) {
//                    log.error("error when closing inputStream");
//                }
//            }
//        }
    }


    @Override
    public Object getBean(String beanId) {
//        return beanFactory.getBean(beanId);
        return null;
    }
}
