package site.pengcheng.designpattern.factory.di;

/**
 * @author pengchengbai
 * @description
 * @date 2020/4/25 5:01 下午
 */
public interface ApplicationContext {
    Object getBean(String beanId);
}
