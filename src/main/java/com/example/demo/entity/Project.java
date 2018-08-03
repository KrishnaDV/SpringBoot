package com.example.demo.entity;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "project")
@NamedQuery(name="Project.findByName",query="select p.employees from Project p where p.name = :name")
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
