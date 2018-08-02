package com.example.demo.entity;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "project")
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "proj_id")
	private int id;
	
	@Column(name = "proj_name")
	private String name;

	@ManyToMany(mappedBy="projects")
	private Set<Employee> employees;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Project() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
