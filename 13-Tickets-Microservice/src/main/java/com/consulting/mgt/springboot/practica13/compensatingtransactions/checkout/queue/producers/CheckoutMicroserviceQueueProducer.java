package com.consulting.mgt.springboot.practica13.compensatingtransactions.checkout.queue.producers;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.consulting.mgt.springboot.practica13.compensatingtransactions.checkout.queue.CheckoutMicroserviceQueues;
import com.consulting.mgt.springboot.practica13.compensatingtransactions.checkout.queue.event.ReservationCheckoutWithdrawalEvent;

import lombok.extern.slf4j.Slf4j;

@Slf4j
// Define Bean de servicio
public class CheckoutMicroserviceQueueProducer {

	// Inyecta JMS Template

	// Inyecta Supplier<String> secureRandomUUID

	public void reservationCheckoutWithdrawal(String user, int ticketOrderId, double amount, String creditCardNumber) {

		// Implementa

	}
}