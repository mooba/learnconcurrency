package site.pengcheng.designpattern.refactor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Random;

/**
 * @author pengchengbai
 * @description
 * @date 2020/4/10 11:46 上午
 */

public interface IdGenerator {
    String generate();
}