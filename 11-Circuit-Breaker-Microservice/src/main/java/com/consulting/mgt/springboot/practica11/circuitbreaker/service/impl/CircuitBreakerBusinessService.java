package com.consulting.mgt.springboot.practica11.circuitbreaker.service.impl;

import java.util.function.Function;
import java.util.function.Supplier;

import com.consulting.mgt.springboot.practica11.circuitbreaker.controller.model.StatusResponse;
import com.consulting.mgt.springboot.practica11.circuitbreaker.service.IBusinessService;
import com.consulting.mgt.springboot.practica11.circuitbreaker.service.exception.ServiceException;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.vavr.control.Try;

public class CircuitBreakerBusinessService implements IBusinessService {

	// Defina Target object IBusinessService businessService
	private final IBusinessService businessService;

	// Defina propiedad Circuit Breaker
	private final CircuitBreaker circuitBreaker;

	// Defina propiedad Supplier<StatusResponse> decoratedSupplier
	private  Supplier<StatusResponse> decoratedSupplier;

	// Inyecte por constructor propiedades IBusinessService businessService, CircuitBreaker circuitBreaker
	// En el constructor decore el Supplier mediante CircuitBreaker.decorateSupplier(this.circuitBreaker, this.businessService::perform);
	public CircuitBreakerBusinessService(IBusinessService businessService, CircuitBreaker circuitBreaker) {
		this.businessService = businessService;
		this.circuitBreaker = circuitBreaker;
		
		this.decoratedSupplier = CircuitBreaker.decorateSupplier(circuitBreaker, 
															businessService::perform);
	}

	@Override
	public StatusResponse perform() throws ServiceException {
		
		return Try.ofSupplier(this.decoratedSupplier)
					.recover(this::fallback)
					.get();
	}

	// Defina metodo fallback
	public StatusResponse fallback(Throwable th) {
		return new StatusResponse(204, "DEFAULT STATUS"); 
	}

}
