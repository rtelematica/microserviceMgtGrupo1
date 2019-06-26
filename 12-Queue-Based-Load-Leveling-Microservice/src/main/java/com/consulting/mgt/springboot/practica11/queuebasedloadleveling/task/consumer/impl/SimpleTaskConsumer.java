package com.consulting.mgt.springboot.practica11.queuebasedloadleveling.task.consumer.impl;

import com.consulting.mgt.springboot.practica11.queuebasedloadleveling.model.Message;
import com.consulting.mgt.springboot.practica11.queuebasedloadleveling.task.ITaskConsumer;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
// elimina abstract
public class SimpleTaskConsumer implements ITaskConsumer {

	// Implementa
	private int delay;

	public SimpleTaskConsumer(int delay) {
		this.delay = delay;
	}

	@SneakyThrows
	@Override
	public void consume(Message message) {

		Thread.sleep(delay);

		log.info(message.getMessage() + " is consumed.");
	}

}
