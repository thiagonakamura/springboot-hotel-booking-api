package com.example.springboot_hotel_booking_api.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot_hotel_booking_api.dtos.UserRecordDto;
import com.example.springboot_hotel_booking_api.entities.UserEntity;
import com.example.springboot_hotel_booking_api.services.UserService;

import jakarta.validation.Valid;

/**
 * REST Controller for managing user-related operations.
 * This controller handles CRUD operations for users, including retrieving, creating, updating, and deleting users.
 * 
 * The endpoints return appropriate HTTP responses along with user data.
 */
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	//Retrieves a list of all users
	@GetMapping
	public ResponseEntity<List<UserEntity>> getAllUsers(){
		return ResponseEntity.ok().body(userService.getAllUsers());
	}
	
	//Retrieves a single user by ID.
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserEntity> getOneUser(@PathVariable Long id){
		UserEntity user = userService.getOneUser(id);
		return ResponseEntity.ok().body(user);
	}
	
	//Saves a new user to the system.
	@PostMapping
	public ResponseEntity<UserEntity> saveUser(@RequestBody @Valid UserRecordDto userRecordDto){
		var user = new UserEntity();
		BeanUtils.copyProperties(userRecordDto, user);
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(user));
	}
	
	//Updates an existing user by ID
	@PutMapping(value = "/{id}")
	public ResponseEntity<UserEntity> updateUser(@PathVariable Long id,@RequestBody @Valid UserRecordDto userRecordDto){
		UserEntity user = userService.getOneUser(id);
		BeanUtils.copyProperties(userRecordDto, user);
		return ResponseEntity.ok().body(userService.updateUser(id, user));
	}
	
	//Deletes a user by ID.
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id){
		userService.deleteUser(id);
		return ResponseEntity.ok().body("User with id " + id + " deleted.");
	}
}
