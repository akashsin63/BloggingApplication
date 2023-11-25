package com.blogging.blog.controllers;

import com.blogging.blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.blogging.blog.payloads.UserDTO;

import com.blogging.blog.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	//POST -> creat user
	//PUT -> update user
	//DELETE -> delete 
	// GET  --> get user / get all user
	
	@Autowired
	private UserService userService;
	
	//POST 
	@GetMapping("/")
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDto){
		UserDTO createUserDto = this.userService.createUser(userDto);
		return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
	}
}
