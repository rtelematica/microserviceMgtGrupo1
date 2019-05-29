package com.consulting.mgt.springboot.practica1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlumnosRestController {
	
	@RequestMapping("/")
	public String saludo() {
		return "Hola Mundo Spring Boot Initializr";
	}
	
}