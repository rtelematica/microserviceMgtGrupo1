package com.consulting.mgt.springboot.practica11.queuebasedloadleveling.task.producer.impl;

import com.consulting.mgt.springboot.practica11.queuebasedloadleveling.model.Message;
import com.consulting.mgt.springboot.practica11.queuebasedloadleveling.task.ITaskProducer;
import com.consulting.mgt.springboot.practica11.queuebasedloadleveling.task.consumer.impl.SimpleTaskConsumer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
// Elimina abstract
public class SimpleTaskProducer implements ITaskProducer, Runnable {

	// Implementa
	private int messageCount;
	private SimpleTaskConsumer taskConsumer;
	private int delay;
	
	public SimpleTaskProducer(int messageCount, SimpleTaskConsumer simpleTaskConsumer, int delay) {
		this.messageCount = messageCount;
		this.taskConsumer = simpleTaskConsumer;
		this.delay = delay;
	}

	@Override
	public void run() {

		int count = this.messageCount;

		try {

			while (count > 0) {
				String statusMessage = "Message-" + count + 
						" produced by " + Thread.currentThread().getName();

				Thread.sleep(delay);

				log.info("{}", statusMessage);

				this.produce(new Message(statusMessage));

				count--;
			}

		} catch (Exception ex) {
			log.error(ex.getMessage());
		}

	}

	@Override
	public void produce(Message message) {
		taskConsumer.consume(message);
	}

}