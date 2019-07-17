package com.consulting.mgt.springboot.practica19.account.observer;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.consulting.mgt.springboot.practica19.account.events.AccountCreatedEvent;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AccountCreatedListener {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private Queue accountCreatedLogQueue;

	// Implemente lo necesario para cumplir con el requerimiento del slide 408
	@SneakyThrows
	@EventListener
	public void handleAccountCreatedEvent(AccountCreatedEvent ace) {
		log.info("sending Account Created Event to {}", accountCreatedLogQueue.getName());
		
		String message = objectMapper.writeValueAsString(ace);
		
		rabbitTemplate.convertAndSend(accountCreatedLogQueue.getName(), message);
		
		log.info("--------------------------------------------------------------");
	}
}
