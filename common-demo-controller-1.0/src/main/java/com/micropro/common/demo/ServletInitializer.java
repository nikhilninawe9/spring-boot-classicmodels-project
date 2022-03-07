package com.micropro.common.demo;

import java.sql.Timestamp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.context.WebApplicationContext;

// The application starts from this class
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CommonDemoControllerApplication.class);
	}

	@Override
	protected WebApplicationContext run(SpringApplication application) {
		WebApplicationContext context = (WebApplicationContext) application.run();

		System.out.println(new Timestamp(System.currentTimeMillis()).toString()
				+ " --> [common-demo-controller-1.0] Started Successfully");
		return context;
	}

}