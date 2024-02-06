package com.example.SwaggerConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ Author     ：赵棱泉.
 * @ Date       ：Created in 08:06 2022/2/15
 * @ Description：
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket createRestApi() {

		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.any())
//				.apis(RequestHandlerSelectors.basePackage("com.example.controller"))
				.paths(PathSelectors.any())
				.build();
	}

	/**
	 * 该套 API 说明，包含作者、简介、版本、host、服务URL
	 *
	 * @return
	 */

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("接口文档")
				.description("接口文档")
				.contact(new Contact("zlq", "http://localhost:8181/doc.html", "abc@qq.com"))
				.version("1.0")
				.build();
	}

}
