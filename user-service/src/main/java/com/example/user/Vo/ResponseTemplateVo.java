package com.example.user.Vo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.user.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseTemplateVo {

	private User user;
	private Department department;
 
//	public ResponseTemplateVo(String msg){
//		ResponseEntity<String> rs =new ResponseEntity<String>(msg,HttpStatus.OK);
//		System.out.println(msg);
//	;
//	}
	
}
