package com.grievanceredressalsystem.adminmanagementservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//@EnableJpaRepositories(basePackages = "com.grievanceredressalsystem.adminmanagementservice.repository")
public class AdminManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminManagementServiceApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
}
