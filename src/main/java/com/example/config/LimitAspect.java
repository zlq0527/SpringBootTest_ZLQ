package com.example.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author :zlq
 * @date : 2024/2/3
 */
@Aspect
@Component
public class LimitAspect {

    @Autowired
    private RedisTemplate redisTemplate;

    @Around("@annotation(limit)")
    public void Limit(ProceedingJoinPoint joinPoint,Limit limit) throws Throwable {

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        String id = attributes.getRequest().getSession().getId();
        Integer value = ((Integer) redisTemplate.opsForValue().get(id));
        if (value == null) {
            //初始化
            redisTemplate.opsForValue().set(id, 1, limit.limit(), limit.timeUnit());
        } else {
            value++;
            if (value > limit.maxcount()) {
                throw new RuntimeException("请求过于频繁");
            }
            redisTemplate.opsForValue().set(id, value, 0);
        }
        joinPoint.proceed();
    }
}
