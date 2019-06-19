package com.consulting.mgt.springboot.practica13.compensatingtransactions.tickets.queue.producers;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.consulting.mgt.springboot.practica13.compensatingtransactions.tickets.queue.TicketsMicroserviceQueues;
import com.consulting.mgt.springboot.practica13.compensatingtransactions.tickets.queue.event.CancelTicketReservationEvent;

import lombok.extern.slf4j.Slf4j;

@Slf4j
// Defina Bean de servicio
public class TicketsMicroserviceQueueProducer {

	// Inyecte JMS Template

	// Inyecte Supplier<String> secureRandomUUID;

	public void cancelTicketReservation(int ticketOrderId) {

		// Implemente
	}
}