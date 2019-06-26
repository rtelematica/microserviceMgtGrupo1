package com.consulting.mgt.springboot.practica14.throttling._config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.consulting.mgt.springboot.practica14.throttling.throttler.CallsCount;
import com.consulting.mgt.springboot.practica14.throttling.throttler.Tenant;
import com.consulting.mgt.springboot.practica14.throttling.throttler.ThrottleTimerImpl;
import com.consulting.mgt.springboot.practica14.throttling.throttler.Throttler;

// Define clase de configuracion
@Configuration
public class ThrottlingConfig {

	// Define bean CallsCount callsCounter
	@Bean
	public CallsCount callsCounter() {
		return new CallsCount();
	}

	// Define bean Throttler throttler, llama a su metodo de inicializacion
	@Bean(initMethod = "start")
	public Throttler throttler() {
		return new ThrottleTimerImpl(1000, callsCounter());
	}

	// Define bean Map<String, Tenant> tenantsMap
	@Bean
	public Map<String, Tenant> tenantsMap() {
		Map<String, Tenant> hashMap = new HashMap<>();

		Tenant tenant1 = new Tenant("xvanhalenx", 1, callsCounter());
		Tenant tenant2 = new Tenant("pepe", 1, callsCounter());

		hashMap.put(tenant1.getName(), tenant1);
		hashMap.put(tenant2.getName(), tenant2);

		return hashMap;
	}

}
