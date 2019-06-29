package com.consulting.mgt.springboot.practica19.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.consulting.mgt.springboot.practica19.account.events.AccountCreatedEventBuilder;
import com.consulting.mgt.springboot.practica19.account.model.Account;
import com.consulting.mgt.springboot.practica19.account.repository.AccountRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;

	// Inyecte la dependencia faltante

	public void createAccount(Account account) {

		log.info("create account service start");

		accountRepository.save(account);

		log.info("publishing Account Created Event");
		
		// Implemente la logica faltante
	}
}
