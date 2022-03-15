package com.example.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.Vo.ResponseTemplateVo;
import com.example.user.entity.User;
import com.example.user.service.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
	@Autowired
	private UserService service;

	@PostMapping("/save")
	public User saveUser(@RequestBody User user) {
		log.info("inside saveUser method of UserController");

		return service.saveUser(user);
	}
	@GetMapping("/{id}")
	@CircuitBreaker(name = "USER-SERVICE",fallbackMethod ="userServiceFallback")
	public ResponseTemplateVo getUserDetails(@PathVariable ("id") Long id){
		log.info("inside getUserDetails method of userController");

		return service.getUserDetails(id);
	}
	public ResponseTemplateVo userServiceFallback(Exception e) {
		
		return new ResponseTemplateVo();
	}
}
