package com.consulting.mgt.springboot.practica15.eventsourcing.events.domainevents;

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
public class AccountCreateEvent extends DomainEvent {

	private static final long serialVersionUID = 1L;

	private int accountNo;
	private String owner;

	// Define constructor
	public AccountCreateEvent(long sequenceId, long createdTime, int accountNo, String owner) {
		super(sequenceId, createdTime, AccountCreateEvent.class.getSimpleName());
		this.accountNo = accountNo;
		this.owner = owner;
	}

	@Override
	public void process() {
		// implementa
		Account account = AccountHolder.getAccount(owner);
		if(account!= null) {
			throw new AccountException("Account already exists");
		}
		account = Account.builder().accountNo(accountNo).owner(owner).build();
		account.handleEvent(this);
	}
	
}
