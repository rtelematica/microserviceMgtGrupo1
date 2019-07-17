package com.consulting.mgt.springboot.practica19.log._config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

	@Bean
	public Queue userCreatedLogQueue() {
		return new Queue("ivan.usercreated.log.queue", true);
	}

	@Bean
	public Queue accountCreatedLogQueue() {
		return new Queue("ivan.accountcreated.log.queue", true);
	}
}
