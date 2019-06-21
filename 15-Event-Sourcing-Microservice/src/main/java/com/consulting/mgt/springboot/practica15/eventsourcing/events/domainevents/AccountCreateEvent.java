package com.consulting.mgt.springboot.practica15.eventsourcing.events.domainevents;

import com.consulting.mgt.springboot.practica15.eventsourcing.events.DomainEvent;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
// descomenta @EqualsAndHashCode(callSuper = true)
//descomenta @ToString(callSuper = true)
public class AccountCreateEvent /* descomenta extends DomainEvent */ {

	private static final long serialVersionUID = 1L;

	private int accountNo;
	private String owner;

	// Define constructor

	// @Override
	public void process() {
		// implementa
	}
}
