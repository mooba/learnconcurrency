package site.pengcheng.designpattern.refactor;

import java.util.Date;

/**
 * @author pengchengbai
 * @description
 * @date 2020/4/9 11:42 下午
 */
public class DemoTest {
    public void calculateDelayDaysTest_with_DelayTimeBiggerThan0() {
        Demo demo = new Demo() {
            @Override
            protected long getDelayTime(Date dueTime) {
                return 86400L;
            }
        };
        long days = demo.calculateDelayDays(new Date());
        Assert.assertEquals(1L, days);
    }

}
