package com.consulting.mgt.springboot.practica11.circuitbreaker.controller.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatusResponse {
	
	private int statusCode;
	private String status;
}
