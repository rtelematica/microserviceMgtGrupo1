package com.consulting.mgt.springboot.practica18.gateway.client.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.consulting.mgt.springboot.practica18.gateway.client.ImageMicroserviceClient;

@Service
public class ImageMicroserviceClientImpl implements ImageMicroserviceClient {

	@Value("${image-microservice.url}")
	private String imageUri;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public String getImagePath() {

		return restTemplate.getForObject(imageUri+"/image-path", String.class);
	}
}
