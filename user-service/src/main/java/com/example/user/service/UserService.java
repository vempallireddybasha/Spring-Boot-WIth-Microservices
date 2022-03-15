package com.example.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.user.Vo.Department;
import com.example.user.Vo.ResponseTemplateVo;
import com.example.user.entity.User;
import com.example.user.repo.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	@Autowired
	private UserRepository repository;
	@Autowired
	private RestTemplate restTemplate;
	
	public User saveUser(User user) {
		log.info("inside saveUser of userService");
		return repository.save(user);
	}
	public ResponseTemplateVo getUserDetails(Long id) {
		ResponseTemplateVo vo =new ResponseTemplateVo();
		User user=repository.findByUserId(id);
		Department department=restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getUserId(), Department.class);
		vo.setDepartment(department);
		vo.setUser(user);
		return vo;
	}

}
