package site.pengcheng.designpattern.refactormetrics;

import com.google.gson.Gson;

import java.util.Map;

/**
 * @author pengchengbai
 * @description
 * @date 2020/4/11 6:36 下午
 */
public class ConsoleViewer implements StatsViewer {
    @Override
    public void output(Map<String, RequestStat> stats, long startTimeInMillis, long endTimeInMillis) {
        System.out.println("Time Span: [" + startTimeInMillis + ", " + endTimeInMillis + "]");
        Gson gson = new Gson();
        System.out.println(gson.toJson(stats));
    }
}
