package com.swagger.config;

import com.google.common.base.Predicates;
import org.assertj.core.util.Preconditions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.DefaultConfiguration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * ======================
 * Created By User: RXK
 * Date: 2017/12/16
 * Time: 13:56
 * Version: V1.0
 * Description:
 * ======================
 */
@Configuration
@EnableSwagger2
public class config
{

	@Value("${Swagger.show}")
	private Boolean isShow;

	//可以定义多个集合 用于存放多个参数
	static List<Parameter> webParamter = new ArrayList<>();

	static
	{
		ParameterBuilder pb = new ParameterBuilder();
		pb.name("accessToken")
			.description("令牌")
			.modelRef(new ModelRef("string"))
			.parameterType("header")
			.required(false)
			.build();

		Parameter pm = pb.build();
		webParamter.add(pm);
	}

	@Bean
	public Docket createTest()
	{
		return new Docket(DocumentationType.SWAGGER_2).enable(true) //当前API文档是否在页面上显示 true 显示 false 不显示
				.groupName("Test_Swagger2")  //当前API文档的搜索栏的标题
				.genericModelSubstitutes(DeferredResult.class)
				.useDefaultResponseMessages(false)  //使用Spring Boot 默认的状态码返回；如果有自己的统一封装类 就使用false ；
				.forCodeGeneration(true)
				.pathMapping("/")  //默认的路径
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.swagger.controller"))
				.paths(Predicates.or(PathSelectors.regex("/api/.*")))
				.build()
				.globalOperationParameters(webParamter)
				.apiInfo(TestInfo());
	}


	public ApiInfo TestInfo()
	{
		return new ApiInfoBuilder().title("This is the Api Doc Title e.g: 当前项目的名称") //大标题
				.description("This is description for title e.g: 当前API使用于后台或者APP或者那些方面") //描述
				.version("This is version of the current API e.g:V1.0")
				.termsOfServiceUrl("AAA of service")
				.contact(new Contact("Create By Who? e.g: RXK", "See more at Where? e.g: 官网", "RXK@healthmall.com"))
				.license("The Apache License, Version 2.0")  //证书 下面是证书的链接
				.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
				.build();
	}


}
