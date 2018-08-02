package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "designation")
public class Designation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "desg_id", nullable = false)
	private int id;
	
	@Column(name = "desg_name", length = 200)
	private String position;
	
	@Column(name = "salary")
	private double salary;
	
	@OneToOne(mappedBy="designation")
	private Employee emp;
	
	
	public Employee getEmp() {
		return emp;
	}

	public Designation() {

	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
}
