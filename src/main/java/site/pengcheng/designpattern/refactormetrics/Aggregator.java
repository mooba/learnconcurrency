package site.pengcheng.designpattern.refactormetrics;

import java.util.*;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

/**
 * @author pengchengbai
 * @description
 * @date 2020/4/9 11:30 上午
 */
public class Aggregator {

    public Map<String, RequestStat> aggregate(Map<String, List<RequestInfo>> requestInfos, long durationInMillis) {
        Map<String, RequestStat> stats = new HashMap<>();
        for (Map.Entry<String, List<RequestInfo>> entry : requestInfos.entrySet()) {
            String apiName = entry.getKey();
            List<RequestInfo> requestInfosPerApi = entry.getValue();
            RequestStat requestStat = doAggregate(requestInfosPerApi, durationInMillis);
            stats.put(apiName, requestStat);
        }
        return stats;
    }

    public RequestStat doAggregate(List<RequestInfo> requestInfos, long durationInMillis) {
        List<Double> respTimeList = requestInfos.parallelStream()
                .map(RequestInfo::getResponseTime)
                .collect(Collectors.toList());

        RequestStat requestStat = new RequestStat();
        DoubleSummaryStatistics summaryStatistics = respTimeList.stream().mapToDouble(i -> i).summaryStatistics();
        requestStat.setMaxResponseTime(summaryStatistics.getMax());
        requestStat.setMinResponseTime(summaryStatistics.getMin());
        requestStat.setAvgResponseTime(summaryStatistics.getAverage());
        requestStat.setP999ResponseTime(percentile999(respTimeList));
        requestStat.setP99ResponseTime(percentile99(respTimeList));
        requestStat.setCount(respTimeList.size());
        requestStat.setTps(tps(respTimeList.size(), durationInMillis));
        return requestStat;
    }


    private long tps(int count, double durationInMillis) {
        return (long)(count / durationInMillis * 1000);
    }


    private double percentile999(List<Double> dataset) {
        dataset.sort(Comparator.naturalOrder());
        int count = dataset.size();
        int idx999 = (int)(count * 0.999);
        return dataset.get(idx999);
    }


    private double percentile99(List<Double> dataset) {
        dataset.sort(Comparator.naturalOrder());
        int count = dataset.size();
        int idx99 = (int)(count * 0.99);
        return dataset.get(idx99);
    }


    private double percentile(List<Double> dataset, double ratio) {
        dataset.sort(Comparator.naturalOrder());
        int count = dataset.size();
        int idx = (int) (count * ratio);
        return dataset.get(idx);
    }

}
