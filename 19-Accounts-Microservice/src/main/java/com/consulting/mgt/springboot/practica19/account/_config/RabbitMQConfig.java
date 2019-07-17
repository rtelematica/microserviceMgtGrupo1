package com.consulting.mgt.springboot.practica19.account._config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

	@Bean
	public Queue userCreatedAccountQueue() {
		return new Queue("ivan.usercreated.account.queue", true);
	}

	@Bean
	public Queue accountCreatedLogQueue() {
		return new Queue("ivan.accountcreated.log.queue", true);
	}
}
