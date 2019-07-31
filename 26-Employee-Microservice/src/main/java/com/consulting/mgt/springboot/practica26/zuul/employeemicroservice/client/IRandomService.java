package com.consulting.mgt.springboot.practica26.zuul.employeemicroservice.client;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import com.consulting.mgt.springboot.practica26.zuul.employeemicroservice.MyListener;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;

@FeignClient(name = "${random-microservice.service-name:random-microservice}", 
			 path = "${random-microservice.context-path:random-service}", 
			 fallbackFactory = IRandomServiceFallbackFactory.class)
public interface IRandomService {

	@GetMapping("/next")
	public Map<String, Object> next();
}

@Slf4j
@Component
class IRandomServiceFallbackFactory implements FallbackFactory<IRandomService> {

	@Autowired
	private Environment env;

	@Override
	public IRandomService create(Throwable cause) {

		log.info("[Fallback FallbackFactory<IRandomService>] Throwable cause: {}", 
				cause.getMessage());
		
		return new IRandomService() {

			@Override
			public Map<String, Object> next() {

				Map<String, Object> map = new LinkedHashMap<>();

				map.put("random", -1);
				map.put("from",
						"http://" + env.getProperty("spring.application.name") + ":" 
													+ MyListener.APPLICATION_PORT);

				log.info("[Fallback FallbackFactory<IRandomService>] "
										+ "sending random number {}", map.get("random"));

				return map;
			}
		};
	}

}