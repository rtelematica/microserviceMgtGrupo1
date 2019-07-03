package com.consulting.mgt.springboot.practica18.gateway._config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class GatewayMicroserviceConfig {

	// Define RestTemplate restTemplate
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
