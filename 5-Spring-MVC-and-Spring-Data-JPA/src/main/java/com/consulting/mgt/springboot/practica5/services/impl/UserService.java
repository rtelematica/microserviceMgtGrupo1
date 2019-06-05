package com.consulting.mgt.springboot.practica5.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.consulting.mgt.springboot.practica5.entities.User;
import com.consulting.mgt.springboot.practica5.repositories.UserRepository;
import com.consulting.mgt.springboot.practica5.services.api.IUserService;

// define service, imeplementa IUserService
@Service
public class UserService implements IUserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public Page<User> findPaginated(Pageable pageable) {
		return this.userRepository.findAll(pageable);
	}

	@Override
	public void saveOrUpdate(User user) {
		this.userRepository.save(user);
	}

	@Override
	public User searchById(long id) {
		return this.userRepository.findById(id).orElseThrow(
				() -> new IllegalArgumentException("Invalid user Id:" + id));
	}

	@Override
	public void delete(User user) {
		this.userRepository.delete(user);
		
	}
	
}