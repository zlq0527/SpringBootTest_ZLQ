package com.example.config;

import com.alibaba.fastjson.JSON;
import org.springframework.boot.ApplicationArguments;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationRunner implements org.springframework.boot.ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("appliacation runner: " + JSON.toJSONString(args));
    }
}
