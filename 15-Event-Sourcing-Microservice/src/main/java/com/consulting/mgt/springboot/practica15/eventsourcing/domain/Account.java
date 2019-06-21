package com.consulting.mgt.springboot.practica15.eventsourcing.domain;

import java.math.BigDecimal;

import com.consulting.mgt.springboot.practica15.eventsourcing.events.domainevents.AccountCreateEvent;
import com.consulting.mgt.springboot.practica15.eventsourcing.events.domainevents.MoneyDepositEvent;
import com.consulting.mgt.springboot.practica15.eventsourcing.events.domainevents.MoneyTransferEvent;
import com.consulting.mgt.springboot.practica15.eventsourcing.events.domainevents.MoneyWithdrawalEvent;
import com.consulting.mgt.springboot.practica15.eventsourcing.events.exception.AccountException;
import com.consulting.mgt.springboot.practica15.eventsourcing.holder.AccountHolder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {

	private int accountNo;

	private String owner;

	@Builder.Default
	private BigDecimal money = new BigDecimal(0);

	public Account clone() {
		Account account = Account.builder()
				.accountNo(accountNo)
				.owner(owner)
				.money(money).build();
		return account;
	}

	private void depositMoney(BigDecimal money) {
		this.money = this.money.add(money);
	}

	private void withdrawMoney(BigDecimal money) {
		this.money = this.money.subtract(money);
	}
	
	public void handleEvent(AccountCreateEvent accountCreateEvent) {
		AccountHolder.putAccount(this);
		if (accountCreateEvent.isRealTime()) {
			log.info("Some external api for only realtime execution could be called here.");
		}
	}

	public void handleEvent(MoneyDepositEvent moneyDepositEvent) {
		handleDeposit(moneyDepositEvent.getMoney(), moneyDepositEvent.isRealTime());
	}

	public void handleEvent(MoneyWithdrawalEvent moneyWithdrawalEvent) {
		handleWithdrawal(moneyWithdrawalEvent.getMoney(), moneyWithdrawalEvent.isRealTime());
	}

	public void handleTransferFromEvent(MoneyTransferEvent moneyTransferEvent) {
		handleWithdrawal(moneyTransferEvent.getMoney(), moneyTransferEvent.isRealTime());
	}

	public void handleTransferToEvent(MoneyTransferEvent moneyTransferEvent) {
		handleDeposit(moneyTransferEvent.getMoney(), moneyTransferEvent.isRealTime());
	}
	
	private void handleDeposit(BigDecimal money, boolean realTime) {

		depositMoney(money);

		AccountHolder.putAccount(this);

		if (realTime) {
			log.info("Some external api for only realtime execution could be called here.");
		}
	}

	private void handleWithdrawal(BigDecimal money, boolean realTime) {

		if (this.money.compareTo(money) == -1) {
			throw new AccountException("Insufficient Account Balance");
		}

		withdrawMoney(money);

		AccountHolder.putAccount(this);

		if (realTime) {
			log.info("Some external api for only realtime execution could be called here.");
		}
	}

}
