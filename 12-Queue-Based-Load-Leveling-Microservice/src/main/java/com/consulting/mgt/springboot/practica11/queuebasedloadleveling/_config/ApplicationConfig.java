package com.consulting.mgt.springboot.practica11.queuebasedloadleveling._config;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

	// Implementa
	public static int PRODUCER_TASK_DELAY;
	public static int CONSUMER_TASK_DELAY;
	
	public ApplicationConfig(	@Value("${producer.task.delay}") int ptd, 
								@Value("${consumer.task.delay}") int ctd ) {
		PRODUCER_TASK_DELAY = ptd;
		CONSUMER_TASK_DELAY = ctd;
	}
	
	@Bean
	public ExecutorService myExecutorService() {
		return Executors.newFixedThreadPool(2);
	}

}
