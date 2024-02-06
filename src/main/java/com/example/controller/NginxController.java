package com.example.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ Author     ：赵棱泉.
 * @ Date       ：Created in 20:04 2022/3/15
 * @ Description：
 */
@Controller
public class NginxController {

	@RequestMapping("/")
	public String test() {
		return "Nginx";
	}
}
