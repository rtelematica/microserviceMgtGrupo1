package com.consulting.mgt.springboot.practica18.gateway.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consulting.mgt.springboot.practica18.gateway.aggregates.DesktopProductAggregate;
import com.consulting.mgt.springboot.practica18.gateway.aggregates.MobileProductAggregate;
import com.consulting.mgt.springboot.practica18.gateway.client.ImageMicroserviceClient;
import com.consulting.mgt.springboot.practica18.gateway.client.PriceMicroserviceClient;

// Define RestController
@RestController
public class ApiGatewayController {
	
	@Autowired
	private ImageMicroserviceClient imageClient;
	
	@Autowired
	private PriceMicroserviceClient priceClient;

	// Implementa
	@GetMapping("/desktop")
	public DesktopProductAggregate desktop() {
		return new DesktopProductAggregate(
				priceClient.getPrice(), 
				imageClient.getImagePath());
	}
	
	@GetMapping("/mobile")
	public MobileProductAggregate mobile() {
		return new MobileProductAggregate(
				priceClient.getPrice());
	}
}
