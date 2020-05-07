package site.pengcheng.designpattern.factory.di;

/**
 * @author pengchengbai
 * @description
 * @date 2020/4/25 6:46 下午
 */
public class NoSuchBeanDefinitionException extends RuntimeException{
    public NoSuchBeanDefinitionException() {
        super();
    }

    public NoSuchBeanDefinitionException(String message) {
        super(message);
    }

    public NoSuchBeanDefinitionException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchBeanDefinitionException(Throwable cause) {
        super(cause);
    }
}
