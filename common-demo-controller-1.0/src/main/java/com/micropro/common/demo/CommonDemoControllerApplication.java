package com.micropro.common.demo;

import java.sql.Timestamp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CommonDemoControllerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommonDemoControllerApplication.class, args);

		System.out.println(new Timestamp(System.currentTimeMillis()).toString()
				+ " --> [common-demo-controller-1.0] Started Successfully");
	}

}