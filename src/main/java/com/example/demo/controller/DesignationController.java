package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.DesignationService;
import com.example.demo.entity.Designation;

@RestController
public class DesignationController {

	@Autowired
	DesignationService ds;
	
	@GetMapping(path = "/designation/{position}", produces = "application/json")
	public Designation getEmployee(@PathVariable String position) {

		return ds.findByPosition(position);
	}
	
}
