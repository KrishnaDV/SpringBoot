package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DemoApplication;
import com.example.demo.Service.EmployeeService;
import com.example.demo.entity.Employee;

@RestController
public class EmployeeController {

	
	private static final Logger LOGGER = LoggerFactory.getLogger(DemoApplication.class);
	
	@Autowired
	EmployeeService es;

	@GetMapping(path = "/employee/{id}", produces = "application/json")
	public Optional<Employee> getEmployee(@PathVariable int id) {

		return es.findEmployee(id);
	}

	@GetMapping(path = "/employee/age/{age}", produces = "application/json")
	public List<Employee> getEmployeeByAge(@PathVariable int age) {

		return es.findEmployeeByAge(age);
	}
	
	
	@GetMapping(path = "/employees", produces = "application/json")
	public List<Employee> getEmployees() {
		LOGGER.info("Inside get all employees");
		return es.findAll();
	}

	@PostMapping(path = "/createEmployee", produces = "application/json", consumes = "application/json")
	public Employee createEmployee(@RequestBody Employee emp) {
		return es.createEmployee(emp);
	}

	@PutMapping(path = "/updateEmployee", produces = "application/json", consumes = "application/json")
	public Employee updateEmployee(@RequestBody Employee emp) {
		return es.updateEmployee(emp);
	}

	@DeleteMapping(path = "/deleteEmployee/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable int id) {
		es.deleteEmployee(id);
		return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
	}
}
