package com.consulting.mgt.springboot.practica22.eurekaclient.helper;

import java.net.URI;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;


@Component
public class DiscoveryClientHelper {

	// Inyecta DiscoveryClient discoveryClient;
	@Autowired
	private DiscoveryClient discoveryClient;

	private Random random = new Random();

	public URI getServiceURI(String appName) {
		// Implementa
		
		List<ServiceInstance> list = getInstances(appName);
		
		if (list != null && list.size() > 0) {
			return list.get(random.nextInt(6) % list.size()).getUri();
		}
		return null;
	}

	public List<ServiceInstance> getInstances(String appName) {
		// Implementa obten instancias del DiscoveryClient
		return discoveryClient.getInstances(appName);
	}
}
