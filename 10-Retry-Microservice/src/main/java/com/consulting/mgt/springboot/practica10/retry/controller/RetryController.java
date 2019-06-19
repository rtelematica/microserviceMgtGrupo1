package com.consulting.mgt.springboot.practica10.retry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.consulting.mgt.springboot.practica10.retry.controller.model.StatusResponse;
import com.consulting.mgt.springboot.practica10.retry.service.IBusinessService;
import com.consulting.mgt.springboot.practica10.retry.service.exception.ServiceException;

@RestController
public class RetryController {

	@Autowired
	private IBusinessService bs;

	@GetMapping("/{retries}")
	public StatusResponse getResponse(@PathVariable int retries) {

		bs.setRetries(retries);

		return bs.perform();
	}

	@GetMapping("/reset")
	public String getReset() {

		bs.setAttempts(0);

		return "reset";
	}

	@ExceptionHandler(ServiceException.class)
	public StatusResponse handleException() {

		return new StatusResponse(500, "UNREACHABLE SERVER");
	}
}
