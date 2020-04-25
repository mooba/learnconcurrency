package site.pengcheng.designpattern.refactormetrics;

import com.google.common.annotations.VisibleForTesting;
import site.pengcheng.designpattern.metrics.EmailSender;


import java.util.*;

/**
 * @author pengchengbai
 * @description
 * @date 2020/4/11 6:14 下午
 */
public class EmailReporter extends ScheduledReporter{
    private static final Long DAY_HOURS_IN_SECONDS = 86400L;


    public EmailReporter(EmailViewer emailViewer) {
        this(new RedisMetricsStorage(), new Aggregator(), emailViewer);
    }

    public EmailReporter(MetricsStorage metricsStorage, Aggregator aggregator, StatsViewer statsViewer) {
        super(metricsStorage, aggregator, statsViewer);
    }

    public void startDailyReport() {
        // 获取当前时间
        Date firstTime = getFirstTime(new Date());
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                long durationInMillis = DAY_HOURS_IN_SECONDS * 1000;
                long endTimeInMillis = System.currentTimeMillis();
                doStatAndReport(durationInMillis, endTimeInMillis);
            }
        }, firstTime, DAY_HOURS_IN_SECONDS * 1000);
    }


    @VisibleForTesting
    protected static Date getFirstTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static void main(String[] args) {
        Date date = EmailReporter.getFirstTime(new Date());
        System.out.println(date.getTime());

    }
}
