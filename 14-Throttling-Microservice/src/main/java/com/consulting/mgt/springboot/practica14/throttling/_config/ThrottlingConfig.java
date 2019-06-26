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
public class ThrottlingConfig {

	// Define bean CallsCount callsCounter

	// Define bean Throttler throttler, llama a su metodo de inicializacion

	// Define bean Map<String, Tenant> tenantsMap

}
