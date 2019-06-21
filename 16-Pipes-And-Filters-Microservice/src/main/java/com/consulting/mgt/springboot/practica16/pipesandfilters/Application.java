package com.consulting.mgt.springboot.practica16.pipesandfilters;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
// Importa el recurso integration-context.xml
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
