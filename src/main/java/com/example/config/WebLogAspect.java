//package com.example.Config;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.Signature;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.Arrays;
//
///**
// * @ Author     ：赵棱泉.
// * @ Date       ：Created in 09:48 2022/2/18
// * @ Description：
// */
//@Aspect
//@Component
//public class WebLogAspect {
//	private final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);
//	@Pointcut("execution(public * com.example.controller..*.*(..))")
//	public void webLog() {
//	}
//	@Before("webLog()")
//	public void dobefore(JoinPoint joinPoint) throws Throwable{
//		System.out.println("----------------");
//		System.out.println(joinPoint.getClass().getName());
//		System.out.println(joinPoint.getSignature().getName());
//		System.out.println(joinPoint.getSignature());
//		System.out.println(Arrays.toString(joinPoint.getArgs()));
//		System.out.println("----------------");
//		Signature signature = joinPoint.getSignature();
//		System.out.println("--------------");
//		String[] parameterNames = ((MethodSignature) signature).getParameterNames();
//		Object[] args = joinPoint.getArgs();
//		StringBuilder stringBuilder = new StringBuilder();
//		for (String parm : parameterNames) {
//			stringBuilder.append(parm).append(",");
//		}
//		System.out.println("请求参数:"+stringBuilder);
//		for (Object i : args) {
//			System.out.println("传递值:"+i);
//		}
//		for (int i = 0; i < parameterNames.length; i++) {
//			System.out.println("参数名->"+parameterNames[i]+"参数值"+args[i]);
//		}
//
//		System.out.println(joinPoint.getSignature().getDeclaringTypeName());
//		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//		HttpServletRequest request = attributes.getRequest();
////		joinPoint.getSignature().va
////		 记录下请求内容
//		logger.info("URL : " + request.getRequestURL().toString());
//		logger.info("HTTP_METHOD : " + request.getMethod());
//		logger.info("IP : " + request.getRemoteAddr());
//		logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
//		logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
//	}
////	@AfterReturning(returning = "ret", pointcut = "webLog()")
////	public void doAfterReturning(Object ret) throws Throwable {
////		// 处理完请求，返回内容
////		logger.info("RESPONSE : " + ret);
////	}
//
//}
