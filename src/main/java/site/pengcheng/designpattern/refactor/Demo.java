package site.pengcheng.designpattern.refactor;

import com.google.common.annotations.VisibleForTesting;

import java.util.Date;

/**
 * @author pengchengbai
 * @description
 * @date 2020/4/9 11:42 下午
 */
public class Demo {
    protected long getDelayTime(Date dueTime) {
        long currentTimestamp = System.currentTimeMillis();
        return currentTimestamp - dueTime.getTime();
    }

    public long calculateDelayDays(Date dueTime) {
        long delayTime = getDelayTime(dueTime);
        if (delayTime <= 0) {
            return 0;
        }
        long delayDays = delayTime / 86400;
        return delayDays;
    }
}
