package com.consulting.mgt.springboot.practica15.eventsourcing.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.consulting.mgt.springboot.practica15.eventsourcing.events.DomainEvent;
import com.consulting.mgt.springboot.practica15.eventsourcing.events.domainevents.AccountCreateEvent;
import com.consulting.mgt.springboot.practica15.eventsourcing.holder.AccountHolder;

import lombok.SneakyThrows;

@Component
public class DomainEventProcessor {

	@Autowired
	private JsonFileJournal processorJournal;

	public void process(DomainEvent domainEvent) {

		// Implementa
		domainEvent.process();

		processorJournal.write(domainEvent);
	}

	public void reset() {
		
		// Implementa
		processorJournal.reset();
	}

	@SneakyThrows
	public void recover() {

		// Implementa
		processorJournal.readJournal();

		DomainEvent domainEvent;

		while (true) {
			domainEvent = processorJournal.readNext();
			
			Thread.sleep(1000);
			
			if (domainEvent == null) {
				break;
			} else {
				AccountHolder.setSequenceId(domainEvent.getSequenceId());
				
				if(domainEvent instanceof AccountCreateEvent) {
					AccountCreateEvent ace = (AccountCreateEvent)domainEvent;
					AccountHolder.setAccountId(ace.getAccountNo());
				}
				domainEvent.process();
			}
		}
	}
}
