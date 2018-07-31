package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

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

import com.example.demo.Service.EmployeeService;
import com.example.demo.entity.Employee;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService es;

	@GetMapping(path = "/employee/{id}", produces = "application/json")
	public Optional<Employee> getEmployee(@PathVariable int id) {

		return es.findEmployee(id);
	}

	@GetMapping(path = "/employees", produces = "application/json")
	public List<Employee> getEmployees() {

		return es.findAll();
	}

	@PostMapping(path = "/create", produces = "application/json", consumes = "application/json")
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
