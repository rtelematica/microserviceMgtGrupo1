package com.consulting.mgt.springboot.practica9.embedded.broker.service.consumer;

import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.consulting.mgt.springboot.practica9.embedded.broker.service._config.ActiveMQConfig;
import com.consulting.mgt.springboot.practica9.embedded.broker.service.model.Order;

import lombok.extern.slf4j.Slf4j;

@Slf4j
// Define como Bean
public class OrderConsumer {

	// Define JMS Listener que escuche la queue destino ORDER_QUEUE
	public void receiveMessage(Order order, MessageHeaders headers, Message message, Session session) {
		log.info("received <" + order.getId() + ">");

		log.info("- - - - - - - - - - - - - - - - - - - - - - - -");
		log.info("######          Message Details           #####");
		log.info("- - - - - - - - - - - - - - - - - - - - - - - -");
		log.info("headers: " + headers);
		log.info("message: " + message);
		log.info("session: " + session);
		log.info("- - - - - - - - - - - - - - - - - - - - - - - -");
	}

}