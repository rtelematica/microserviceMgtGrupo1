package com.consulting.mgt.springboot.practica15.eventsourcing.events.domainevents;

import java.math.BigDecimal;

import com.consulting.mgt.springboot.practica15.eventsourcing.domain.Account;
import com.consulting.mgt.springboot.practica15.eventsourcing.events.DomainEvent;
import com.consulting.mgt.springboot.practica15.eventsourcing.events.exception.AccountException;
import com.consulting.mgt.springboot.practica15.eventsourcing.holder.AccountHolder;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MoneyTransferEvent extends DomainEvent {

	private static final long serialVersionUID = 1L;

	private BigDecimal money;
	private int accountNoFrom;
	private int accountNoTo;

	// Define constructor
	public MoneyTransferEvent(long sequenceId, long createdTime, 
			BigDecimal money, int accountNoFrom, int accountNoTo) {
		super(sequenceId, createdTime, MoneyTransferEvent.class.getSimpleName());
		this.money = money;
		this.accountNoFrom = accountNoFrom;
		this.accountNoTo = accountNoTo;
	}

	@Override
	public void process() {

		Account accountFrom = AccountHolder.getAccount(accountNoFrom);
		if (accountFrom == null) {
			throw new AccountException("Account not found " + accountNoFrom);
		}

		Account accountTo = AccountHolder.getAccount(accountNoTo);
		if (accountTo == null) {
			throw new AccountException("Account not found " + accountNoTo);
		}

		accountFrom.handleTransferFromEvent(this);
		accountTo.handleTransferToEvent(this);
	}
}
