package com.consulting.mgt.springboot.practica23.ribbon.usersmicroservice.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.consulting.mgt.springboot.practica23.ribbon.usersmicroservice.client.AgeServiceClient;
import com.consulting.mgt.springboot.practica23.ribbon.usersmicroservice.client.IUppercaseService;
import com.consulting.mgt.springboot.practica23.ribbon.usersmicroservice.model.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class UsersRestController {

	@Autowired
	private AgeServiceClient ageServiceClient;

	@Autowired
	private IUppercaseService uppercaseServiceClient;

	@GetMapping("/{name}")
	public User users(@PathVariable String name) {

		log.info("Sending User");

		return new User(uppercaseServiceClient.toUppercase(name),
				ageServiceClient.getAge());
	}
}
