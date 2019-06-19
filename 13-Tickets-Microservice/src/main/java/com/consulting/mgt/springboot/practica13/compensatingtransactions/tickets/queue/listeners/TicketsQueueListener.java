package com.consulting.mgt.springboot.practica13.compensatingtransactions.tickets.queue.listeners;

import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.consulting.mgt.springboot.practica13.compensatingtransactions.checkout.queue.producers.CheckoutMicroserviceQueueProducer;
import com.consulting.mgt.springboot.practica13.compensatingtransactions.tickets.queue.TicketsMicroserviceQueues;
import com.consulting.mgt.springboot.practica13.compensatingtransactions.tickets.queue.event.CancelTicketReservationEvent;
import com.consulting.mgt.springboot.practica13.compensatingtransactions.tickets.queue.event.TicketReservationEvent;

import lombok.extern.slf4j.Slf4j;

@Slf4j
// Define Bean
public class TicketsQueueListener {

	@Autowired
	private CheckoutMicroserviceQueueProducer checkoutMicroserviceQueueProducer;

	private boolean ticketReservation = true;

	private boolean ticketReservationCompensation = true;

	// Define JMS Listener de queue TicketsMicroserviceQueues.TICKET_RESERVATION_QUEUE
	public void ticketReservation(@Payload TicketReservationEvent reservationEvent,
			@Headers MessageHeaders headers,
			Message message,
			Session session) {

		// Implementa
	}

	// Define JMS Listener de queue TicketsMicroserviceQueues.CANCEL_TICKET_RESERVATION_QUEUE
	public void ticketReservationCompenstation(@Payload CancelTicketReservationEvent reservationEvent,
			@Headers MessageHeaders headers,
			Message message,
			Session session) {

		// Implementa
	}

	private boolean successTicketReservation() {
		return ticketReservation;
	}

	private boolean successTicketReservationCompensation() {
		return ticketReservationCompensation;
	}

}