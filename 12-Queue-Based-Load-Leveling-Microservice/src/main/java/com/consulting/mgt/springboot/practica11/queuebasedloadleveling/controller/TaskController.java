package com.consulting.mgt.springboot.practica11.queuebasedloadleveling.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.consulting.mgt.springboot.practica11.queuebasedloadleveling.service.ITaskService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
// Define Rest Controller
@RestController
public class TaskController {

	// Inyecta ITaskService
	@Autowired
	private ITaskService taskService;

	@GetMapping("/{triggeredTasks}")
	public String getResponse(@PathVariable int triggeredTasks) {

		// Implementa
		long startTime = System.nanoTime();

		String response = taskService.triggerTasks(triggeredTasks);

		long estimatedTime = System.nanoTime() - startTime;

		String elapsedTimeText = String.format(
				"elapsed time %s sec.", ((double) estimatedTime / 1000000000));

		log.info("{}", elapsedTimeText);

		return response + " " + elapsedTimeText;
	}

}
