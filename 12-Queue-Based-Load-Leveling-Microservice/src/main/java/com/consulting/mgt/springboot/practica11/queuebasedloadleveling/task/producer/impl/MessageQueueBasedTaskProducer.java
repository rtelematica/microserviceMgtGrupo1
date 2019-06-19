package com.consulting.mgt.springboot.practica11.queuebasedloadleveling.task.producer.impl;

import java.util.Date;

import com.consulting.mgt.springboot.practica11.queuebasedloadleveling.model.Message;
import com.consulting.mgt.springboot.practica11.queuebasedloadleveling.queue.MessageQueue;
import com.consulting.mgt.springboot.practica11.queuebasedloadleveling.task.ITaskProducer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
// Elimina abstract
public abstract class MessageQueueBasedTaskProducer implements ITaskProducer, Runnable {

	// Implementa
}