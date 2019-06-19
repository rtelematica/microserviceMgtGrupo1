package com.consulting.mgt.springboot.practica11.queuebasedloadleveling.task.producer.impl;

import com.consulting.mgt.springboot.practica11.queuebasedloadleveling.model.Message;
import com.consulting.mgt.springboot.practica11.queuebasedloadleveling.task.ITaskProducer;
import com.consulting.mgt.springboot.practica11.queuebasedloadleveling.task.consumer.impl.SimpleTaskConsumer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
// Elimina abstract
public abstract class SimpleTaskProducer implements ITaskProducer, Runnable {

	// Implementa
}