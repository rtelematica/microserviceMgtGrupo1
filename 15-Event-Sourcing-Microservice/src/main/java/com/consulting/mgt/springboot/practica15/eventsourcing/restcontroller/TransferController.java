package com.consulting.mgt.springboot.practica15.eventsourcing.restcontroller;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consulting.mgt.springboot.practica15.eventsourcing.domain.Account;
import com.consulting.mgt.springboot.practica15.eventsourcing.events.domainevents.MoneyTransferEvent;
import com.consulting.mgt.springboot.practica15.eventsourcing.holder.AccountHolder;
import com.consulting.mgt.springboot.practica15.eventsourcing.processor.DomainEventProcessor;

@RestController
@RequestMapping("/transfer")
public class TransferController {

	@Autowired
	private DomainEventProcessor domainEventProcessor;

	@GetMapping("/from/{tenantFrom}/to/{tenantTo}/amount/{amount}")
	public String accountOf(@PathVariable String tenantFrom,
			@PathVariable String tenantTo,
			@PathVariable BigDecimal amount) {

		// Implementa
		
		return null;
	}
}
