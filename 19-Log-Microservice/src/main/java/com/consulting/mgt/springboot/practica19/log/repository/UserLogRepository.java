package com.consulting.mgt.springboot.practica19.log.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consulting.mgt.springboot.practica19.log.model.User;

public interface UserLogRepository extends JpaRepository<User, Integer> {

}
