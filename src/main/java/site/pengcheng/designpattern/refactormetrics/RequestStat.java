package site.pengcheng.designpattern.refactormetrics;

import lombok.Data;

/**
 * @author pengchengbai
 * @description
 * @date 2020/4/9 11:59 上午
 */
@Data
public class RequestStat {
    private double maxResponseTime;
    private double minResponseTime;
    private double avgResponseTime;
    private double p999ResponseTime;
    private double p99ResponseTime;
    private long count;
    private long tps;
}
