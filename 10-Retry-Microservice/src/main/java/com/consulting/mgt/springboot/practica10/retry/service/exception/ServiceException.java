package com.consulting.mgt.springboot.practica10.retry.service.exception;

public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ServiceException(String message) {
		super(message);
	}
}
