package com.consulting.mgt.springboot.practica25.hystrix.sentencemicroservice.client.impl;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.consulting.mgt.springboot.practica25.hystrix.sentencemicroservice.client.INounServiceClient;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class NounServiceClient implements INounServiceClient {

	@Value("${noun-microservice.service-name:noun-microservice}")
	private String serviceName;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	@SneakyThrows
	// Define comando Hystrix
	public String getNoun() {
		URI uri = new URI(String.format("http://%s/word", serviceName));

		log.info("calling service URI {}", uri.toURL());

		return restTemplate.getForObject(uri, String.class);
	}

	public String defaultNoun(Throwable ex) {
		log.info("Fallback method entered, exception {}: {}", ex.getClass().getSimpleName(), ex.getMessage());
		log.error("exception", ex);
		return "(some noun)";
	}

}
