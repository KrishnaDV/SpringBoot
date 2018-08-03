package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "designation")
@NamedQuery(name="Designation.findByPosition",query="select d from Designation d where d.position = :position")
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
public class Designation {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "desg_id", nullable = false)
	private int id;

	@Column(name = "desg_name", length = 200)
	private String position;

	@Column(name = "salary")
	private double salary;
	
	
	@OneToOne(mappedBy="designation")
	private Employee employee;
	
	public Designation(int id, String position, double salary, Employee employee) {
		super();
		this.id = id;
		this.position = position;
		this.salary = salary;
		this.employee = employee;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Designation() {

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
