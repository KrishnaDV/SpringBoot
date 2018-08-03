package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Designation;
import com.example.demo.repository.DesignationRepository;

@Service
public class DesignationService {

	@Autowired
	DesignationRepository dr;

	public Designation findByPosition(String position) {
		return dr.findByPosition(position);
	}

}
