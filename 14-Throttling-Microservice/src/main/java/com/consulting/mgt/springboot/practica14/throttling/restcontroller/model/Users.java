package com.consulting.mgt.springboot.practica14.throttling.restcontroller.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {

	public List<User> users;
}
