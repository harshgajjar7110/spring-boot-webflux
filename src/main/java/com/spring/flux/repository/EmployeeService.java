package com.spring.flux.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.flux.modal.Employee;

import reactor.core.publisher.Flux;

@Service
public class EmployeeService {
@Autowired
private EmployeeRepository repository;


public Flux<Employee> findAll(){
	return repository.findByName("harsh");
}
public void saveEmployee(Employee employee){
	 repository.save(employee).subscribe();
	
}	
	
}
