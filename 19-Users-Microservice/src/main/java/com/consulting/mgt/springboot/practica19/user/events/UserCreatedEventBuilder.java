package com.consulting.mgt.springboot.practica19.user.events;

import com.consulting.mgt.springboot.practica19.user.model.User;

public class UserCreatedEventBuilder {

	public static UserCreatedEvent build(User user) {
		return UserCreatedEvent.builder()
				.id(user.getId())
				.name(user.getName())
				.email(user.getEmail())
				.build();
	}
}
