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
public class MoneyDepositEvent extends DomainEvent {

	private static final long serialVersionUID = 1L;

	private BigDecimal money;
	private int accountNo;

	// Define constructor
	public MoneyDepositEvent(long sequenceId, long createdTime, int accountNo, BigDecimal money) {
		super(sequenceId, createdTime, MoneyDepositEvent.class.getSimpleName());
		this.money = money;
		this.accountNo = accountNo;
	}
	

	// @Override
	public void process() {
		// Implementa
		Account account = AccountHolder.getAccount(accountNo);
		if(account == null) {
			throw new AccountException("Account not found");
		}
		account.handleEvent(this);		
	}
}
