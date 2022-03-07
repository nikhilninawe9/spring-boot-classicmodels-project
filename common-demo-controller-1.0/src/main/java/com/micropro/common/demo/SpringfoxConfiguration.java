package com.micropro.common.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringfoxConfiguration {

	// Swagger code
	private static final String DOCKET_GROUP_NAME = "Micropro Software Solutions Pvt. Ltd.";

	@Bean
	Docket generatedDocket() {
		return docket().groupName(DOCKET_GROUP_NAME);
	}

	public Docket docket() {
		List<Parameter> parameters = new ArrayList<Parameter>();
		Parameter authHeader = new ParameterBuilder().parameterType("header").name("Authorization")
				.defaultValue("HMIS1.0 YjXzGtMJSegkSNeHFPrDo5Z4nag").modelRef(new ModelRef("string")).build();
		Parameter rightId = new ParameterBuilder().parameterType("header").name("rightId").defaultValue("0")
				.modelRef(new ModelRef("string")).build();
		parameters.add(authHeader);
		parameters.add(rightId);
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.micropro.common.demo")).build().apiInfo(apiInfo())
				.globalOperationParameters(parameters);
	}

	public ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Micropro DEMO REST api")
				.description("Generated documentation for Micropro DEMO").termsOfServiceUrl("").version("1.0.0")
				.contact(new Contact("", "", "")).build();
	}

}