package com.sk.dep.staff.admin.menu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableSwagger2
@SpringBootApplication

public class ServiceStaffMenuApplication {
	private static final Logger logger = LoggerFactory.getLogger(ServiceStaffMenuApplication.class); 
	public static void main(String[] args) {
		SpringApplication.run(ServiceStaffMenuApplication.class, args);
		logger.info("Main{}");
	}
}
