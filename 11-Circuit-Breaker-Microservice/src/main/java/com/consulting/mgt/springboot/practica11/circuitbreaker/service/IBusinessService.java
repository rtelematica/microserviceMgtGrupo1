package com.consulting.mgt.springboot.practica11.circuitbreaker.service;

import com.consulting.mgt.springboot.practica11.circuitbreaker.controller.model.StatusResponse;

@FunctionalInterface
public interface IBusinessService {

	StatusResponse perform();
}
