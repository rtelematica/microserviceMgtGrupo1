package com.consulting.mgt.springboot.practica11.queuebasedloadleveling._config;

import java.util.concurrent.ExecutorService;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.consulting.mgt.springboot.practica11.queuebasedloadleveling._config.profile.QueuedBasedProfile;
import com.consulting.mgt.springboot.practica11.queuebasedloadleveling.queue.MessageQueue;
import com.consulting.mgt.springboot.practica11.queuebasedloadleveling.service.ITaskService;
import com.consulting.mgt.springboot.practica11.queuebasedloadleveling.service.impl.TaskService;
import com.consulting.mgt.springboot.practica11.queuebasedloadleveling.task.consumer.impl.MessageQueueBasedTaskConsumer;
import com.consulting.mgt.springboot.practica11.queuebasedloadleveling.task.producer.impl.MessageQueueBasedTaskProducer;
import com.consulting.mgt.springboot.practica11.queuebasedloadleveling.task.producer.impl.SimpleTaskProducer;

@Configuration
@QueuedBasedProfile
public class QueuedBasedProfileConfiguration {

	// Implementa
	
	@Autowired
	private ObjectFactory<MessageQueueBasedTaskProducer> 
											messageQueuedTaskProducerObjectFactory;

	@Autowired
	@Qualifier("myExecutorService")
	private ExecutorService myExecutorService;

	@Bean
	public MessageQueue messageQueue() {
		return new MessageQueue();
	}
	
	@Bean
	public ITaskService taskService() {
		return new TaskService(myExecutorService, messageQueuedTaskProducerObjectFactory);
	}
	
	@Bean
	@Scope("prototype")
	public MessageQueueBasedTaskProducer messageQueueBasedTaskProducer(
													MessageQueue messageQueue) {
		return new MessageQueueBasedTaskProducer(
							1, 
							messageQueue, 
							ApplicationConfig.PRODUCER_TASK_DELAY);
	}

	@Bean
	public MessageQueueBasedTaskConsumer messageQueueBasedTaskConsumer() {
		return new MessageQueueBasedTaskConsumer(
							messageQueue(), 
							ApplicationConfig.CONSUMER_TASK_DELAY);
	}
	
	@Bean
	public CommandLineRunner startConsumer(
			MessageQueueBasedTaskConsumer messageQueueBasedTaskConsumer) {
		return (args) -> {
			myExecutorService.submit(messageQueueBasedTaskConsumer);
		};
	}

}
