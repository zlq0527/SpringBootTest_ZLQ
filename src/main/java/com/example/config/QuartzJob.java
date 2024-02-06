package com.example.config;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class QuartzJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        String NAME = (String) jobExecutionContext.getJobDetail().getJobDataMap().get("Name");
        String URL = (String) jobExecutionContext.getJobDetail().getJobDataMap().get("blogUrl");
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd:HH:mm:ss");
        System.out.println("Name------" + NAME);
        System.out.println("URL-------" + URL);
        System.out.println("当前时间" + dateFormat.format(date));
        System.out.println("----------------------------------------");
    }
}
