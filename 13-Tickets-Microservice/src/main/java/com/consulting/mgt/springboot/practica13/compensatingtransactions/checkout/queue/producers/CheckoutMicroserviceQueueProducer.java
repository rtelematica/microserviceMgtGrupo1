package com.consulting.mgt.springboot.practica13.compensatingtransactions.checkout.queue.producers;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.consulting.mgt.springboot.practica13.compensatingtransactions.checkout.queue.CheckoutMicroserviceQueues;
import com.consulting.mgt.springboot.practica13.compensatingtransactions.checkout.queue.event.ReservationCheckoutWithdrawalEvent;

import lombok.extern.slf4j.Slf4j;

@Slf4j
// Define Bean de servicio
@Component
public class CheckoutMicroserviceQueueProducer {

	// Inyecta JMS Template
	@Autowired
	private JmsTemplate jmsTemplate;

	// Inyecta Supplier<String> secureRandomUUID
	@Autowired
	private Supplier<String> secureRandomUUID;

	public void reservationCheckoutWithdrawal(String user, int ticketOrderId, double amount, String creditCardNumber) {

		// Implementa
		ReservationCheckoutWithdrawalEvent event = new ReservationCheckoutWithdrawalEvent(
				secureRandomUUID.get(), user, ticketOrderId, amount, creditCardNumber);

		log.info("---");
		log.info(
				"[Tickets Microservice] sending "
				+ "'reservation checkout withdrawal' event "
				+ "for ticket order Id {} to queue {}.",
				event.getTicketOrderId(), 
				CheckoutMicroserviceQueues.RESERVE_WITHDRAWAL_QUEUE);
		log.info("---");

		jmsTemplate.convertAndSend(CheckoutMicroserviceQueues.RESERVE_WITHDRAWAL_QUEUE, 
																					event);

	}
}