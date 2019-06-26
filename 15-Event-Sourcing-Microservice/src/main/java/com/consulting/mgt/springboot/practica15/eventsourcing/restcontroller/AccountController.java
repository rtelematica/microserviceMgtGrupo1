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
		return AccountHolder.getAll();
	}

	@GetMapping("/{owner}")
	public Account accountOf(@PathVariable String owner) {

		// Implementa
		return AccountHolder.getAccount(owner);
	}

	@GetMapping("/{owner}/create")
	public String createAccountOf(@PathVariable String owner) {

		// Implementa
		AccountCreateEvent newAccount = new AccountCreateEvent(
				AccountHolder.nextSequenceId(),
				new Date().getTime(),
				AccountHolder.nextAccountId(),
				owner);

		domainEventProcessor.process(newAccount);

		Account tenantAccount = AccountHolder.getAccount(newAccount.getAccountNo());

		return tenantAccount.getOwner() + " account created !";
	}

	@GetMapping("/{owner}/deposit/{amount}")
	public String accountDeposit(@PathVariable String owner, @PathVariable BigDecimal amount) {

		// Implementa
		Account tenantAccount = AccountHolder.getAccount(owner);

		MoneyDepositEvent moneyDeposit = new MoneyDepositEvent(
				AccountHolder.nextSequenceId(),
				new Date().getTime(),
				tenantAccount.getAccountNo(),
				amount);

		domainEventProcessor.process(moneyDeposit);

		return owner + " deposit done !";
	}

	@GetMapping("/{owner}/withdrawal/{amount}")
	public String accountWithdrawal(@PathVariable String owner, @PathVariable BigDecimal amount) {

		// Implementa
		Account tenantAccount = AccountHolder.getAccount(owner);

		MoneyWithdrawalEvent moneyWithdrawal = new MoneyWithdrawalEvent(
				AccountHolder.nextSequenceId(),
				new Date().getTime(),
				tenantAccount.getAccountNo(),
				amount);

		domainEventProcessor.process(moneyWithdrawal);

		return owner + " withdrawal done !";
	}
}
