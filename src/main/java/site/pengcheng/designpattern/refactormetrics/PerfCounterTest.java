package site.pengcheng.designpattern.refactormetrics;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author pengchengbai
 * @description
 * @date 2020/4/10 10:18 下午
 */
public class PerfCounterTest {
    public static void main(String[] args) {
        ConsoleReporter consoleReporter = new ConsoleReporter();
        consoleReporter.startRepeatedReport(60, 60);

        EmailViewer emailViewer = new EmailViewer(Collections.singletonList("pengcheng.bai@shopee.com"));
        EmailReporter emailReporter = new EmailReporter(emailViewer);
        emailReporter.startDailyReport();


        MetricsCollector collector = new MetricsCollector();
        collector.recordRequest(new RequestInfo("register", 123, 10234));
        collector.recordRequest(new RequestInfo("register", 223, 11234));
        collector.recordRequest(new RequestInfo("register", 323, 12334));
        collector.recordRequest(new RequestInfo("login", 23, 12434));
        collector.recordRequest(new RequestInfo("login", 1223, 14234));

        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
