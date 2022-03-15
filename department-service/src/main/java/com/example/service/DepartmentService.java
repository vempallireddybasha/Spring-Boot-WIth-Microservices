package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.entity.Department;
import com.example.repo.DepartmentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentService {

	@Autowired
	private DepartmentRepository repository;

	public Department saveDepartment(Department department) {
		log.info("inside saveDepartment method of Departmentservice");
		return repository.save(department);
	}

	public Department getDepartment(Long id) {
		log.info("inside getDepartment method of Departmentservice");
		return repository.findByDepartmentId(id);
	}	
}
