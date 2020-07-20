package com.example.app.api.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ApiZuulGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiZuulGatewayApplication.class, args);
	}

}
