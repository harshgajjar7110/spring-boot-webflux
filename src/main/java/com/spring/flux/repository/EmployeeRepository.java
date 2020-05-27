package com.spring.flux.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.spring.flux.modal.Employee;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface EmployeeRepository extends ReactiveMongoRepository<Employee, String>{

	  Mono<Employee> findOneByName(final String firstName);
	  Flux<Employee> findByName(final String firstName);

	

}
