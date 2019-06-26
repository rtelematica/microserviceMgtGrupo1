package com.consulting.mgt.springboot.practica11.queuebasedloadleveling.task.consumer.impl;

import com.consulting.mgt.springboot.practica11.queuebasedloadleveling.model.Message;
import com.consulting.mgt.springboot.practica11.queuebasedloadleveling.queue.MessageQueue;
import com.consulting.mgt.springboot.practica11.queuebasedloadleveling.task.ITaskConsumer;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
// elimina abstract
public class MessageQueueBasedTaskConsumer implements ITaskConsumer, Runnable {

	// Implementa
	private final MessageQueue messageQueue;
	private int delay;

	public MessageQueueBasedTaskConsumer(MessageQueue messageQueue, int delay) {
		this.messageQueue = messageQueue;
		this.delay = delay;
	}

	@Override
	public void run() {
		
		try {
			while (!Thread.currentThread().isInterrupted()) {

				Message message = messageQueue.retrieveMessage();

				if (null != message) {
					this.consume(message);
				} else {
					log.info("Service Executor: Waiting for Messages to serve .. ");
				}
				
				Thread.sleep(3000);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	@SneakyThrows
	@Override
	public void consume(Message message) {
		
		Thread.sleep(delay);

		log.info(message.getMessage() + " is consumed.");
	}

}
