package site.pengcheng.designpattern.refactormetrics;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author pengchengbai
 * @description
 * @date 2020/4/11 6:28 下午
 */
public class ConsoleReporter extends ScheduledReporter{
    private ScheduledExecutorService executor;

    public ConsoleReporter() {
        this(new RedisMetricsStorage(), new Aggregator(), new ConsoleViewer());
    }


    public ConsoleReporter(MetricsStorage metricsStorage, Aggregator aggregator, StatsViewer statsViewer) {
        super(metricsStorage, aggregator, statsViewer);
        this.executor = this.executor = this.executor = Executors.newSingleThreadScheduledExecutor();;
    }

    public void startRepeatedReport(long periodInSeconds, long durationInSeconds) {
        executor.scheduleAtFixedRate(() -> {
            // 第1个代码逻辑：根据给定的时间区间，从数据库中拉取数据；
            long durationInMillis = durationInSeconds * 1000;
            long endTimeInMillis = System.currentTimeMillis();
            doStatAndReport(durationInMillis, endTimeInMillis);
        }, 0, periodInSeconds, TimeUnit.SECONDS);
    }
}
