package com.consulting.mgt.springboot.practica19.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.consulting.mgt.springboot.practica19.user.events.UserCreatedEventBuilder;
import com.consulting.mgt.springboot.practica19.user.model.User;
import com.consulting.mgt.springboot.practica19.user.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {

	// Inyecte Bean ApplicationEventPublisher publisher
	@Autowired
	private ApplicationEventPublisher publisher;

	@Autowired
	private UserRepository userRepository;

	public void createUser(User user) {

		log.info("create user service start");

		userRepository.save(user);

		log.info("publishing User Created Event");
		
		// Implemente envio de evento UserCreatedEvent
		publisher.publishEvent(UserCreatedEventBuilder.build(user));
	}
}
