package site.pengcheng.designpattern.metrics;


import com.google.common.base.Strings;

/**
 * @author pengchengbai
 * @description
 * @date 2020/4/9 11:27 上午
 */
public class MetricsCollector {
    private MetricsStorage metricsStorage;

    // dependency injection
    public MetricsCollector(MetricsStorage metricsStorage) {
        this.metricsStorage = metricsStorage;
    }

    public void recordRequest(RequestInfo requestInfo) {
        if (requestInfo == null || Strings.isNullOrEmpty(requestInfo.getApiName())) {
            return;
        }
        metricsStorage.saveRequestInfo(requestInfo);
    }
}
