package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "phone")
public class Phones {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "phn_id")
	private int id;

	@Column(name = "phn_num", nullable = false, length = 10)
	private String number;

	public int getId() {
		return id;
	}

	public Phones() {
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}
