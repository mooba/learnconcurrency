package site.pengcheng.learnquartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author pengchengbai
 * @description
 * @date 2020/4/9 4:43 下午
 */
public class HelloJob implements org.quartz.Job{

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("Hello!  HelloJob is executing.");
    }
}
