package com.consulting.mgt.springboot.practica24.feign.agemicroservice.client;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

// Agrega Feign Client
@FeignClient(name="random-microservice", path="random-service")
public interface IRandomServiceClient {

	// Agrega "/next" edpoint mediante Metodo GET.
	@GetMapping("/next")
	public Map<String, Object> next();
}
