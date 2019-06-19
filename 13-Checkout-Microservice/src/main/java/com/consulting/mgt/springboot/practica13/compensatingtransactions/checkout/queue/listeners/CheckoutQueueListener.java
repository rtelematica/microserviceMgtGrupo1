package com.consulting.mgt.springboot.practica13.compensatingtransactions.checkout.queue.listeners;

import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.consulting.mgt.springboot.practica13.compensatingtransactions.checkout.queue.CheckoutMicroserviceQueues;
import com.consulting.mgt.springboot.practica13.compensatingtransactions.checkout.queue.event.ReservationCheckoutWithdrawalEvent;
import com.consulting.mgt.springboot.practica13.compensatingtransactions.tickets.queue.producers.TicketsMicroserviceQueueProducer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
// Defina Bean
public class CheckoutQueueListener {

	// Inyecte TicketsMicroserviceQueueProducer ticketsMicroserviceQueueProducer;

	private boolean reservationCheckoutWithdrawal = true;

	// Defina JMS Listener de queue
	// CheckoutMicroserviceQueues.RESERVE_WITHDRAWAL_QUEUE
	public void applyReserveWithdrawal(@Payload ReservationCheckoutWithdrawalEvent reservationEvent,
			@Headers MessageHeaders headers, Message message, Session session) {

		// Implemente
	}

	private boolean successReservationCheckoutWithdrawal() {
		return reservationCheckoutWithdrawal;
	}

}