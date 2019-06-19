package com.consulting.mgt.springboot.practica10.retry.service.impl;

import java.net.URI;

import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.consulting.mgt.springboot.practica10.retry.controller.model.StatusResponse;
import com.consulting.mgt.springboot.practica10.retry.service.IBusinessService;
import com.consulting.mgt.springboot.practica10.retry.service.exception.FailingServiceException;

import lombok.Setter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BusinessService implements IBusinessService {
	
	// Define propiedades Rest Template y String failingServiceURL

	
	private @Setter int retries;
	private @Setter int attempts;

	// Inyecta propiedades Rest Template y String failingServiceURL por constructor
	

	@SneakyThrows
	@Override
	public StatusResponse perform() {

		// Implementa
		
		return null;
	}
}
