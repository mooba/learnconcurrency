package site.pengcheng.designpattern.metrics;

/**
 * @author pengchengbai
 * @description
 * @date 2020/4/9 11:34 上午
 */
public class RequestInfo {
    private String apiName;
    private double responseTime;
    private long timestamp;

    public RequestInfo(String apiName, double responseTime, long timestamp) {
        this.apiName = apiName;
        this.responseTime = responseTime;
        this.timestamp = timestamp;
    }

    public String getApiName() {
        return apiName;
    }

    public double getResponseTime() {
        return responseTime;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public void setResponseTime(double responseTime) {
        this.responseTime = responseTime;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "RequestInfo{" +
                "apiName='" + apiName + '\'' +
                ", responseTime=" + responseTime +
                ", timestamp=" + timestamp +
                '}';
    }
}
