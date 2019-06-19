package com.consulting.mgt.springboot.practica10.retry.service.impl;

import java.util.concurrent.atomic.AtomicInteger;

import com.consulting.mgt.springboot.practica10.retry.controller.model.StatusResponse;
import com.consulting.mgt.springboot.practica10.retry.service.IBusinessService;
import com.consulting.mgt.springboot.practica10.retry.service.exception.ServiceException;

//Cambie de abstract a final
public final class RetryBusinessService implements IBusinessService {

	// Define propiedad Target Object
	private final IBusinessService targetBusinessService;

	private final int maxAttempts;
	private final long delay;
	private final AtomicInteger attempts;

	// Inyecta propiedades por constructor excepto attempts, en el constructor
	// inicializa el atomic integer.
	public RetryBusinessService(IBusinessService businessService, 
			int maxAttempts, long delay) {
		this.targetBusinessService = businessService;
		this.maxAttempts = maxAttempts;
		this.delay = delay;
		this.attempts = new AtomicInteger();
	}

	// Define metodo attempts
	public int attempts() {
		return this.attempts.intValue();
	}

	@Override
	public StatusResponse perform() throws ServiceException {
		// Implemente
		do {
			try {
				return this.targetBusinessService.perform();
			} catch (ServiceException e) {

				if (this.attempts.incrementAndGet() >= this.maxAttempts) {
					throw e;
				}

				try {
					Thread.sleep(this.delay);
				} catch (InterruptedException f) {
					// ignore
				}
			}
		} while (true);
	}

	// Implementa metodo setRetries
	@Override
	public void setRetries(int retries) {
		this.targetBusinessService.setRetries(retries);
	}

	// Implementa metodo setAttempts
	@Override
	public void setAttempts(int i) {
		this.targetBusinessService.setAttempts(i);
		this.attempts.set(0);
	}
}
