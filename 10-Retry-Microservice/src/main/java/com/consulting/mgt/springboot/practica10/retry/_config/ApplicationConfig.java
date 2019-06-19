package com.consulting.mgt.springboot.practica10.retry._config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

import com.consulting.mgt.springboot.practica10.retry.service.IBusinessService;
import com.consulting.mgt.springboot.practica10.retry.service.impl.BusinessService;
import com.consulting.mgt.springboot.practica10.retry.service.impl.RetryBusinessService;

@Configuration
public class ApplicationConfig {

	// Define Bean Rest template

	// Inyecta propiedad String failingServiceURL

	// Define Bean IBusinessService noRetriableBusinessService
	// de tipo concreto BusinessService

	// Define Bean IBusinessService retriableBusinessService
	// de tipo concreto RetryBusinessService

}
