package site.pengcheng.designpattern.factory.di;

/**
 * @author pengchengbai
 * @description
 * @date 2020/4/25 5:32 下午
 */
public class RedisCounter {
    private String ipAddress;
    private int port;
    public RedisCounter(String ipAddress, int port) {
        this.ipAddress = ipAddress;
        this.port = port;
    }
    //...
}
