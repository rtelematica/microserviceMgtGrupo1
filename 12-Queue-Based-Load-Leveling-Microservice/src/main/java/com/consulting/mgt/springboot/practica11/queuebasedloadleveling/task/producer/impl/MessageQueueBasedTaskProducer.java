package com.consulting.mgt.springboot.practica11.queuebasedloadleveling.task.producer.impl;

import java.util.Date;

import com.consulting.mgt.springboot.practica11.queuebasedloadleveling.model.Message;
import com.consulting.mgt.springboot.practica11.queuebasedloadleveling.queue.MessageQueue;
import com.consulting.mgt.springboot.practica11.queuebasedloadleveling.task.ITaskProducer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
// Elimina abstract
public class MessageQueueBasedTaskProducer implements ITaskProducer, Runnable {

	// Implementa
	private int messageCount;
	private final MessageQueue messageQueue;
	private int delay;

	public MessageQueueBasedTaskProducer(
			int messageCount, MessageQueue messageQueue, int delay) {
		this.messageCount = messageCount;
		this.messageQueue = messageQueue;
		this.delay = delay;
	}

	@Override
	public void run() {
		
		int count = this.messageCount;

		try {
			while (count > 0) {

				String statusMessage = "Message-" + count + " produced by " + Thread.currentThread().getName() + " at "
						+ new Date();

				Thread.sleep(delay);

				log.info("{}", statusMessage);

				this.produce(new Message(statusMessage));

				count--;
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}
	
	@Override
	public void produce(Message message) {
		try {
			this.messageQueue.submitMessage(message);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}
}