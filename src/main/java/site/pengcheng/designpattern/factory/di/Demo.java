package site.pengcheng.designpattern.factory.di;

/**
 * @author pengchengbai
 * @description 整个di框架的入口
 * @date 2020/4/25 5:33 下午
 */
public class Demo {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        RateLimiter rateLimiter = (RateLimiter) applicationContext.getBean("RateLimiter");

        rateLimiter.test();

    }

}
