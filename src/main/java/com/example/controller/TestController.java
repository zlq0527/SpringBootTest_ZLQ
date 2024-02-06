package com.example.controller;

import com.example.config.QuartzJob;
import com.example.Service.QiniuService;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @ Author     ：赵棱泉.
 * @ Date       ：Created in 13:09 2022/3/6
 * @ Description：
 */
@Controller
public class TestController {
    @Autowired
    private QiniuService qiniuService;

    @RequestMapping(value = "/testUpload", method = RequestMethod.POST)
    @ResponseBody
    public String uploadImage(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        if (file.isEmpty()) {
            return "未选择任何文件";
        }
        try {
            String fileUrl = qiniuService.saveImage(file);
            return "success, imageUrl = " + fileUrl;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "fail";
    }

    @RequestMapping("/toupload")
    public String toupload() {
        return "upload";
    }

    @RequestMapping("testQuartz")
    public void testQuartz() {
        JobDetail jobDetail = JobBuilder.newJob(QuartzJob.class)
                .withIdentity("job", "group1")
                .build();
    }
}
