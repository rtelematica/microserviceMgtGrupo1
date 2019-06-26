package com.consulting.mgt.springboot.practica15.eventsourcing.restcontroller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consulting.mgt.springboot.practica15.eventsourcing.domain.Account;
import com.consulting.mgt.springboot.practica15.eventsourcing.events.domainevents.AccountCreateEvent;
import com.consulting.mgt.springboot.practica15.eventsourcing.events.domainevents.MoneyDepositEvent;
import com.consulting.mgt.springboot.practica15.eventsourcing.events.domainevents.MoneyWithdrawalEvent;
import com.consulting.mgt.springboot.practica15.eventsourcing.holder.AccountHolder;
import com.consulting.mgt.springboot.practica15.eventsourcing.processor.DomainEventProcessor;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private DomainEventProcessor domainEventProcessor;

	@GetMapping("/")
	public Map<Integer, Account> accounts() {

		// Implementa
		return null;
	}

	@GetMapping("/{tenant}")
	public Account accountOf(@PathVariable String tenant) {

		// Implementa
		return null;
	}

	@GetMapping("/{tenant}/create")
	public String createAccountOf(@PathVariable String tenant) {

		// Implementa
		return null;
	}

	@GetMapping("/{tenant}/deposit/{amount}")
	public String accountDeposit(@PathVariable String tenant, @PathVariable BigDecimal amount) {

		// Implementa
		return null;
	}

	@GetMapping("/{tenant}/withdrawal/{amount}")
	public String accountWithdrawal(@PathVariable String tenant, @PathVariable BigDecimal amount) {

		// Implementa
		return null;
	}
}
