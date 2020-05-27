package com.spring.flux.controller;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.flux.modal.Employee;
import com.spring.flux.repository.EmployeeService;

import reactor.core.publisher.Flux;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@GetMapping(value="getAllEmployee", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
	public Flux<Employee> index() {
		Flux<Employee> flux= service.findAll();
				
		return 	flux.delayElements(Duration.ofMillis(1000));
		}
	
	
	@PostMapping("saveEmployee")
	public Employee saveEmployee(@RequestBody Employee employee) {
		service.saveEmployee(employee);
		
		return 	employee;
		}

}
