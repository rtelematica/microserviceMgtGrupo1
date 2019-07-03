package com.consulting.mgt.springboot.practica19.account.events;

import com.consulting.mgt.springboot.practica19.account.model.Account;

public class AccountCreatedEventBuilder {

	public static AccountCreatedEvent build(Account account) {
		return AccountCreatedEvent.builder()
				.id(account.getId())
				.accountNumber(account.getAccountNumber())
				.userId(account.getUserId())
				.build();
	}
}
