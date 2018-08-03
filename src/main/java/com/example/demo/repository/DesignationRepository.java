package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Designation;

public interface DesignationRepository extends CrudRepository<Designation,Integer> {

	public Designation findByPosition(@Param("position") String position);
	
}
