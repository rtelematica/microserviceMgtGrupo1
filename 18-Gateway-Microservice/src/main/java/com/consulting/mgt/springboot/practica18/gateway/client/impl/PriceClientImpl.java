package com.consulting.mgt.springboot.practica18.gateway.client.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.consulting.mgt.springboot.practica18.gateway.client.PriceMicroserviceClient;

@Service
public class PriceClientImpl implements PriceMicroserviceClient {

	@Value("${price-microservice.url}")
	private String priceUri;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public String getPrice() {

		return restTemplate.getForObject(priceUri+"/price", String.class);
	}
}
