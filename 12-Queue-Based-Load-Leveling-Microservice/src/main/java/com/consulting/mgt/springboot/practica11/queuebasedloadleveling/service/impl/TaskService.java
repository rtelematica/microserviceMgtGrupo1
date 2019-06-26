package com.consulting.mgt.springboot.practica11.queuebasedloadleveling.service.impl;

import java.util.concurrent.ExecutorService;

import org.springframework.beans.factory.ObjectFactory;

import com.consulting.mgt.springboot.practica11.queuebasedloadleveling.service.ITaskService;
import com.consulting.mgt.springboot.practica11.queuebasedloadleveling.task.ITaskProducer;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
// elimina abstract
public class TaskService implements ITaskService {
	
	// Implementa
	private ExecutorService executorService;
	
	private ObjectFactory<? extends ITaskProducer> taskProducerObjectFactory;
	
	public TaskService(	ExecutorService es, 
						ObjectFactory<? extends ITaskProducer> tpof) {
		this.executorService = es;
		this.taskProducerObjectFactory = tpof;
	}
	
	@Override
	public String triggerTasks(int triggeredTasks) {
		
		int triggered = 0;

		for (int i = 0; i < triggeredTasks; i++) {

			ITaskProducer taskProducer = taskProducerObjectFactory.getObject();

			executorService.submit((Runnable) taskProducer);

			triggered++;

			log.info("Task {} triggered !", (i + 1));
		}

		return String.format("%d tasks triggered", triggered);
	}

}
