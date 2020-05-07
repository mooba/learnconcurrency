package site.pengcheng.designpattern.factory.di;

/**
 * @author pengchengbai
 * @description
 * @date 2020/4/25 5:32 下午
 */

public class RateLimiter {
    private RedisCounter redisCounter;
    public RateLimiter(RedisCounter redisCounter) {
        this.redisCounter = redisCounter;
    }
    public void test() {
        System.out.println("Hello World!");
    }
    //...
}

