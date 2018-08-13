package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Project;
import com.example.demo.repository.ProjectRepository;

@Service
public class ProjectService {
	
	@Autowired 
	ProjectRepository pr;

	public List<Project> findEmployees(String name) {
		
		return pr.findByName(name);
	}

}
