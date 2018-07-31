package com.example.demo.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.Employee;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeControllerIntegrationTest {

	@Autowired
	TestRestTemplate restTemplate;

	@Test
	public void should_return_employee_with_id_input() {

		ResponseEntity<Employee> re = restTemplate.getForEntity("/employee/1", Employee.class);

		Employee emp = re.getBody();

		assertEquals(HttpStatus.OK, re.getStatusCode());
		assertEquals("Harish", emp.getName());
	}

}
