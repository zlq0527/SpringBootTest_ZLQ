package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ Author     ：zhaolengquan.
 * @ Date       ：Created in 08:49 2022/4/15
 * @ Description：
 */
@RestController
public class Thread_poll {

	@GetMapping("/thread")
	public int test() throws InterruptedException {

		ThreadPoolExecutor executor = new ThreadPoolExecutor(2,
				5,
				5,
				TimeUnit.SECONDS,
				new LinkedBlockingQueue<>(),
				new ThreadPoolExecutor.AbortPolicy()
		);
		AtomicInteger a = new AtomicInteger(0);
		for (int i = 0; i < 20; i++) {
			try {
				executor.execute(() -> {
					a.incrementAndGet();
					try {
						TimeUnit.SECONDS.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				});
			} catch (Exception e) {
				System.out.println("error" + i);
				a.decrementAndGet();
			}
		}
		TimeUnit.SECONDS.sleep(5);
		executor.shutdown();
		System.out.println("---");
		return a.intValue();
	}
}
