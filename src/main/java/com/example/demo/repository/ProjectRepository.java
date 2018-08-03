package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project,Integer> {

	public List<Project> findByName(@Param("name") String name);
	
}
