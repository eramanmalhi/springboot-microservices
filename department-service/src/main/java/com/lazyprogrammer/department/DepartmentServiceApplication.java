package com.lazyprogrammer.department;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableEurekaClient
public class DepartmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);
	}

	/*
	 * @Bean
	 * 
	 * @LoadBalanced public WebClient lbWebClient() { return WebClient.builder()
	 * .baseUrl("http://localhost/") .defaultHeader(HttpHeaders.CONTENT_TYPE,
	 * MediaType.APPLICATION_JSON_VALUE) .build(); }
	 */

	@Bean
	@LoadBalanced
	public WebClient.Builder getWebClient() {
		return WebClient.builder();
	}

	@Bean
	@LoadBalanced
	public RestTemplate getInstance() {
		return new RestTemplate();
	}

}
