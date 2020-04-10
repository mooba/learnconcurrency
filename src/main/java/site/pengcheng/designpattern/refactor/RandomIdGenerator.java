package site.pengcheng.designpattern.refactor;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

/**
 * @author pengchengbai
 * @description
 * @date 2020/4/10 3:39 下午
 */
public class RandomIdGenerator implements IdGenerator {
    private static final Logger logger = LoggerFactory.getLogger(IdGenerator.class);

    private static final int DEFAULT_RANDOM_STR_LENGTH = 8;

    @Override
    public  String generate() throws IdGenerationFailureException {
        long currentTimeMillis = System.currentTimeMillis();
        String subStrOfHostName = null;
        try {
            getLastPartOfHost();
        } catch (UnknownHostException uhe) {
            throw new IdGenerationFailureException("...", uhe);
        }
        String randomStr = generateRandomStr(8);
        String id = String.format("%s-%d-%s", subStrOfHostName, currentTimeMillis, randomStr);
        return id;
    }


    @VisibleForTesting
    protected String getLastPartOfHostSplitByDot(String hostName) {
        if (Strings.isNullOrEmpty(hostName)) {
            throw new IllegalArgumentException("hostName is null");
        }
        String field = "";
        String[] tokens = hostName.split("\\.");
        if (tokens.length > 0) {
            field = tokens[tokens.length - 1];
        }
        return field;
    }


    @VisibleForTesting
    protected String getLastPartOfHost() throws UnknownHostException{
        String hostName = InetAddress.getLocalHost().getHostName();
        String retStr = getLastPartOfHostSplitByDot(hostName);
        return retStr;
    }


    @VisibleForTesting
    protected String generateRandomStr() {
        return generateRandomStr(DEFAULT_RANDOM_STR_LENGTH);
    }


    /**
     * @description
     * @param len length of the str to be generated
     * @return return empty str if len == 0;
     * @throws IllegalArgumentException if len < 0
    */
    @VisibleForTesting
    protected String generateRandomStr(int len) {
        if (len < 0) {
            throw new IllegalArgumentException("...");
        }
        if (len == 0) {
            return "";
        }
        char[] randomChars = new char[len];
        int count = 0;
        Random random = new Random();
        while (count < len) {
            int maxAscii = 'z';
            int randomAscii = random.nextInt(maxAscii + 1);
            boolean isDigit = Character.isDigit(randomAscii);
            boolean isUppercase = randomAscii >= 'A' && randomAscii <= 'Z';
            boolean isLowercase = randomAscii >= 'a' && randomAscii <= 'z';
            if (isDigit || isLowercase || isUppercase) {
                randomChars[count] = (char) randomAscii;
                ++count;
            }
        }
        return Arrays.toString(randomChars);
    }
}
