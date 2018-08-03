package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Project;

@RestController
public class ProjectController {
	
	
	@Autowired
	ProjectService ps;
	
	@GetMapping(path = "/project/{name}", produces = "application/json")
	public List<Project> getEmployee(@PathVariable String name) {

		return ps.findEmployees(name);
	}

}
