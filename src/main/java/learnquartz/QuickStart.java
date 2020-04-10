package learnquartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;
import static org.quartz.JobBuilder.*;
import static org.quartz.TriggerBuilder.*;
import static org.quartz.SimpleScheduleBuilder.*;

/**
 * @author pengchengbai
 * @description
 * @date 2020/4/9 4:13 下午
 */
public class QuickStart {
    private static Logger log = LoggerFactory.getLogger(QuickStart.class);

    public static void main(String[] args) throws Exception{

        try {
            // Grab the Scheduler instance from the Factory
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

            // and start it off
            scheduler.start();

            JobDetail job = newJob(HelloJob.class)
                    .withIdentity("job1", "group1")
                    .build();

            Trigger trigger = newTrigger()
                    .withIdentity("trigger1", "group1")
                    .startNow()
                    .withSchedule(
                            simpleSchedule().withIntervalInSeconds(20).repeatForever()
                    ).build();

            scheduler.scheduleJob(job, trigger);

            TimeUnit.SECONDS.sleep(600);
            scheduler.shutdown();

        } catch (SchedulerException se) {
            se.printStackTrace();
        }
    }

}
