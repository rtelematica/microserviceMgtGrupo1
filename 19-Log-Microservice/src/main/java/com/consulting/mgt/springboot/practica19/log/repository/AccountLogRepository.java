package com.consulting.mgt.springboot.practica19.log.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consulting.mgt.springboot.practica19.log.model.Account;

public interface AccountLogRepository extends JpaRepository<Account, Integer> {

}
