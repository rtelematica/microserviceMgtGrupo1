package com.consulting.mgt.springboot.practica4;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.consulting.mgt.springboot.practica4.profiles.bean.ConnectionDataBase;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner startup(ConnectionDataBase cdb) {
		
		return (args) -> {
			cdb.init();
		};
	}

}
