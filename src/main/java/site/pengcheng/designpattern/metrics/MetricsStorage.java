package site.pengcheng.designpattern.metrics;

import java.util.List;
import java.util.Map;

/**
 * @author pengchengbai
 * @description
 * @date 2020/4/9 11:27 上午
 */
public interface MetricsStorage {
    void saveRequestInfo(RequestInfo requestInfo);

    /**
     * 获取某个api一段时间内的统计数据
     */
    List<RequestInfo> getRequestInfos(String apiName, long startTimeInMillis, long endTimeInMillis);

    /** 获取所有api一段时间内的统计数据 */
    Map<String, List<RequestInfo>> getRequestInfos(long startTimeInMillis, long endTimeInMillis);
}
