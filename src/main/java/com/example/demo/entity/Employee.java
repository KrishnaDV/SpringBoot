package com.example.demo.entity;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "emp_id", nullable = false, updatable = false)
	private int id;

	@Column(nullable = false, name = "emp_name")
	private String name;

	@Column(nullable = false, name = "emp_age")
	private int age;

	@Embedded
	private Address address;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "desg_id")
	private Designation designation;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Emp_Phones", joinColumns = { @JoinColumn(name = "emp_id") }, inverseJoinColumns = {
			@JoinColumn(name = "phn_id") })
	private Set<Phones> phones;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Emp_Projects", joinColumns = { @JoinColumn(name = "emp_id") }, inverseJoinColumns = {
			@JoinColumn(name = "proj_id") })
	private Set<Project> projects;

	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

	public Set<Phones> getPhones() {
		return phones;
	}

	public void setPhones(Set<Phones> phones) {
		this.phones = phones;
	}

	public Designation getDesignation() {
		return designation;
	}

	public void setDesignation(Designation designation) {
		this.designation = designation;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Employee(int id, String name, int age, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
	}

	public Employee() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
