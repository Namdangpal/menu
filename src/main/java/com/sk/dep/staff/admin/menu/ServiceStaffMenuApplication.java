package com.sk.dep.staff.admin.menu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableSwagger2
@SpringBootApplication

public class ServiceStaffMenuApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceStaffMenuApplication.class, args);
	}
}
