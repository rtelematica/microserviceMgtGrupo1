package com.consulting.mgt.springboot.practica7;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.consulting.mgt.springboot.practica7.appconfig.Feature;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public Map<String, Feature> features() {
		return new ConcurrentHashMap<>();
	}

}
