package com.consulting.mgt.springboot.acmehrsystem.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consulting.mgt.springboot.acmehrsystem.model.Workstation;
import com.consulting.mgt.springboot.acmehrsystem.service.WorkstationService;

import lombok.Setter;

@RestController
@RequestMapping("/v1/workstations")
public class WorkstationController {

	@Autowired
	private @Setter WorkstationService workstationService;

	@GetMapping
	public List<Workstation> getAllWorkstation() {
		return workstationService.retrieveAll();
	}

	@GetMapping("/{workstationId}")
	public Workstation getWorkstation(@PathVariable long workstationId) {
		return workstationService.retrieveById(workstationId);
	}

}