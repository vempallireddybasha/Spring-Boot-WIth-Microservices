package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Department;
import com.example.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

	@Autowired
	private DepartmentService service;
	@PostMapping("/save")
	public Department saveDepartment(@RequestBody Department department) {
		log.info("inside saveDepartment method of DepartmentController");
		
		return service.saveDepartment(department);
	}
	@GetMapping("/{id}")
	public Department getDepartment(@PathVariable("id") Long id){
		log.info("inside getDepartment method of DepartmentController");
		
		return service.getDepartment(id);
	}
}
