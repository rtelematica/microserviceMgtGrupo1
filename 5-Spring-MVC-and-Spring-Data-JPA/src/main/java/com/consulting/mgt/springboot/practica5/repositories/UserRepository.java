package com.consulting.mgt.springboot.practica5.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.consulting.mgt.springboot.practica5.entities.User;

// repositorio
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	// define query method
	List<User> findByName(String name);

}