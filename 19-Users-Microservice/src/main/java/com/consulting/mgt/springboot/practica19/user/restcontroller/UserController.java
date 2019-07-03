package com.consulting.mgt.springboot.practica19.user.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consulting.mgt.springboot.practica19.user.model.User;
import com.consulting.mgt.springboot.practica19.user.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping
	public String postUser(@RequestBody User user) {

		userService.createUser(user);

		return "user created";
	}
}
