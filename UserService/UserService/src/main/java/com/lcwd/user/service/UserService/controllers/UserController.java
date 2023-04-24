package com.lcwd.user.service.UserService.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.user.service.UserService.entities.User;
import com.lcwd.user.service.UserService.services.UserService;


@RestController
@RequestMapping("/users")
public class UserController {
	
	
	@Autowired
	UserService userService;
	
	//create
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		
		User user1 = userService.saveUser(user);
		
		return new ResponseEntity<User>(user1,HttpStatus.CREATED);
	}	
	
	//get single user with id
	@GetMapping("/{userId}")
	public ResponseEntity<User> getUser(@PathVariable String userId){
		User user2 = userService.getUser(userId);
		return new ResponseEntity<User>(user2,HttpStatus.OK);
		
	}
	
	//get all users
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers(){
		List<User>allUser =  userService.getAllUser();
		return new ResponseEntity<List<User>>(allUser,HttpStatus.OK);
	}

}
