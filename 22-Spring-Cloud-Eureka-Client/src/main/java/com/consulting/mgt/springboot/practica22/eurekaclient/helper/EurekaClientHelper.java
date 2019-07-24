package com.consulting.mgt.springboot.practica22.eurekaclient.helper;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

import lombok.SneakyThrows;

@Component
public class EurekaClientHelper {

	// Inyecta EurekaClient eurekaClient;
	@Autowired
	private EurekaClient eurekaClient;

	@SneakyThrows
	public URI getServiceURI(String appName) {
		// Implementa
		return new URI(eurekaClient
				.getNextServerFromEureka(appName, false)
				.getHomePageUrl());
	}

	public List<InstanceInfo> getInstances(String appName) {
		// Implementa
		return eurekaClient.getInstancesByVipAddress(appName, false);
	}
}
