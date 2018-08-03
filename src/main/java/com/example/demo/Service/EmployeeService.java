package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository er;

	public Optional<Employee> findEmployee(int id) {

		try {
			return er.findById(id);
		}

		catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;

	}

	public List<Employee> findAll() {
		return (List<Employee>) er.findAll();
	}

	public Employee createEmployee(Employee emp) {
		return er.save(emp);
	}

	public Employee updateEmployee(Employee emp) {
		if (er.existsById(emp.getId())) {
			return er.save(emp);
		} else
			return null;
	}

	public void deleteEmployee(int id) {

		er.deleteById(id);

	}

	public List<Employee> findEmployeeByAge(int age) {
		
		return er.findByAge(age);
	}

}
