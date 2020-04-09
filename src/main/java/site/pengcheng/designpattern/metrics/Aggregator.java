package site.pengcheng.designpattern.metrics;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author pengchengbai
 * @description
 * @date 2020/4/9 11:30 上午
 */
public class Aggregator {
    public static RequestStat aggregate(List<RequestInfo> requestInfos, long durationInMillis) {
        double maxRespTime = Double.MIN_VALUE;
        double minRespTime = Double.MAX_VALUE;
        double avgRespTime = -1;
        double p999RespTime = -1;
        double p99RespTime = -1;
        double sumRespTime = 0;
        long count = 0;

        for (RequestInfo requestInfo: requestInfos) {
            ++count;
            double respTime = requestInfo.getResponseTime();
            if (maxRespTime < respTime) {
                maxRespTime = respTime;
            }
            if (minRespTime > respTime) {
                minRespTime = respTime;
            }
            sumRespTime += respTime;
        }

        if (count != 0) {
            avgRespTime = sumRespTime / count;
        }
        long tps = (long)(count / durationInMillis * 1000);

        requestInfos.sort(Comparator.comparingDouble(RequestInfo::getResponseTime));
        int idx999 = (int)(count * 0.999);
        int idx99 = (int)(count * 0.99);
        if (count != 0) {
            p999RespTime = requestInfos.get(idx999).getResponseTime();
            p99RespTime = requestInfos.get(idx99).getResponseTime();
        }

        RequestStat requestStat = new RequestStat();
        requestStat.setMaxResponseTime(maxRespTime);
        requestStat.setMinResponseTime(minRespTime);
        requestStat.setAvgResponseTime(avgRespTime);
        requestStat.setP999ResponseTime(p999RespTime);
        requestStat.setP99ResponseTime(p99RespTime);
        requestStat.setCount(count);
        requestStat.setTps(tps);
        return requestStat;
    }




    public static void main(String[] args) {
        RequestInfo requestInfo = new RequestInfo("/hi", 3.0, 3456L);
        Aggregator aggregator = new Aggregator();
        aggregator.test(requestInfo);
        System.out.println(requestInfo);
    }

    private void test(RequestInfo requestInfo) {
        requestInfo.setApiName("/hello");
    }
}
