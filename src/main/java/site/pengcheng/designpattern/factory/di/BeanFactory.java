package site.pengcheng.designpattern.factory.di;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author pengchengbai
 * @description
 * @date 2020/4/25 5:01 下午
 */
public class BeanFactory {
    private Map<String, Object> singletonObjects = new ConcurrentHashMap<>();
    private Map<String, BeanDefinition> beanDefinitions= new ConcurrentHashMap<>();


    public Object getBean(String beanId) throws ClassNotFoundException {
        BeanDefinition beanDefinition = beanDefinitions.get(beanId);
        if (beanDefinition == null) {
            throw new NoSuchBeanDefinitionException("Bean is not defined: " + beanId);
        }

//        return ceateBean(beanDefinition);
        return null;
    }

    public void addBeanDefinitions(List<BeanDefinition> beanDefinitions) throws ClassNotFoundException{
        for (BeanDefinition beanDefinition: beanDefinitions) {
            if (beanDefinition.isLazyInit() || beanDefinition.isSingleton()) {
                continue;
            }



        }
    }


    private Object ceateBean(BeanDefinition beanDefinition) throws ClassNotFoundException {
        if (beanDefinition.isSingleton() && singletonObjects.get(beanDefinition.getId()) != null) {
            return singletonObjects.get(beanDefinition.getId());
        }

        String className = beanDefinition.getClassName();
        Class<?> clazz = Class.forName(className);

        List<ConstructorArg> constructorArgs = beanDefinition.getConstructorArgs();
        for (ConstructorArg arg: constructorArgs) {

        }

        return null;
    }
}
