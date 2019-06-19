package com.consulting.mgt.springboot.practica11.queuebasedloadleveling.task;

import com.consulting.mgt.springboot.practica11.queuebasedloadleveling.model.Message;

public interface ITaskConsumer {

	void consume(Message message);
}
