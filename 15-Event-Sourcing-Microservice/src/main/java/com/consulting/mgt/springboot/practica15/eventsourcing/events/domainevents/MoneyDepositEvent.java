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
//descomenta @EqualsAndHashCode(callSuper = true)
//descomenta @ToString(callSuper = true)
public class MoneyDepositEvent /* descomenta extends DomainEvent */{

	private static final long serialVersionUID = 1L;

	private BigDecimal money;
	private int accountNo;

	// Define constructor

	// @Override
	public void process() {
		// Implementa
	}
}
