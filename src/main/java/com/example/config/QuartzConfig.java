//package com.example.Config;
//
//import org.quartz.*;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class QuartzConfig {
//
//    private static String JOB_GROUP_NAME = "groupName";
//    private static String TRIGGER_GROUP_NAME = "triggerName";
//    @Bean
//    public JobDetail syncUserJobDetail() {
//        JobDetail jobDetail = JobBuilder.newJob(QuartzJob.class)
//                .withIdentity("syncUserJobDetail", JOB_GROUP_NAME)
//                .usingJobData("Name", "zlq")
//                .usingJobData("blogUrl", "yl1727.xyz")
//                .storeDurably()
//                .build();
//        return jobDetail;
//    }
//
//    @Bean
//    public Trigger syncUserJobTrigger() {
//        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/10 * * * * ?");
//        Trigger trigger = TriggerBuilder.newTrigger()
//                .forJob(syncUserJobDetail())
//                .withIdentity("syncUserJobTrigger", TRIGGER_GROUP_NAME)
//                .withSchedule(cronScheduleBuilder)
//                .build();
//        return trigger;
//    }
//
//}
