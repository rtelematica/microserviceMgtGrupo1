package com.consulting.mgt.springboot.practica4.profiles.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.consulting.mgt.springboot.practica4.profiles.bean.api.DummyDataSource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
// Bean in default profile
public class ConnectionDataBase {

	private DummyDataSource datasource;

	// define propiedad myapp.connection.url
	private String connectionURL;

	public ConnectionDataBase(DummyDataSource ds) {
		this.datasource = ds;
	}

	public void init() {
		this.datasource.connect();
		log.info("Connected to: " + connectionURL);
	}
}
