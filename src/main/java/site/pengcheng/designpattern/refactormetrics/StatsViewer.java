package site.pengcheng.designpattern.refactormetrics;

import java.util.Map;

public interface StatsViewer {
    void output(Map<String, RequestStat> stats, long startTimeInMillis, long endTimeInMillis);
}
