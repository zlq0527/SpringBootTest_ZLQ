package com.example.controller;
import com.example.config.Limit;
import com.example.Utils.RedisUtils;
import com.example.repository.Studentdao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * @ Author     ：赵棱泉.
 * @ Date       ：Created in 14:23 2022/2/16
 * @ Description：
 */
@RestController
public class RedisTestController {
	@Autowired
	private Studentdao studentdao;
	@Autowired
	private RedisUtils redisUtils;

	@Autowired
	private RedisTemplate redisTemplate;


	@GetMapping("/test")
	@Limit(timeUnit = TimeUnit.MINUTES, limit = 1, maxcount = 2)
	public String test() {
		return "test22ad";
	}
}
