package com.consulting.mgt.springboot.practica19.user.repository;

import org.springframework.stereotype.Component;

import com.consulting.mgt.springboot.practica19.user.model.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UserRepository {

	public static int nexUserId() {
		return (int) (Math.random() * 1000000L);
	}

	public void save(User user) {
		user.setId(nexUserId());
		log.info("user {} saved", user);
	}
}
