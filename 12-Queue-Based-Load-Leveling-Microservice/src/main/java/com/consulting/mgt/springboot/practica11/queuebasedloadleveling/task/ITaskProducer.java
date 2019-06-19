package com.consulting.mgt.springboot.practica11.queuebasedloadleveling.task;

import com.consulting.mgt.springboot.practica11.queuebasedloadleveling.model.Message;

public interface ITaskProducer {

	void produce(Message message);
}
