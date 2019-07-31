package com.consulting.mgt.springboot.practica24.feign.usersmicroservice.client;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

//Agrega Feign Client
@FeignClient(name="age-microservice", path="age-service")
public interface IAgeServiceClient {

	// Agrega "/age" edpoint mediante Metodo GET.
	@GetMapping("/age")
	public Map<String, Object> age();
}