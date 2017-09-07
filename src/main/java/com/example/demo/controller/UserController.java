package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDto;
import com.example.demo.service.UserService;

/**
 * Created by ashish on 13/5/17.
 */
@RequestMapping("/user")
@RestController
public class UserController {
	@Autowired
	UserService userService;

	@RequestMapping("/getUser/{userId}")
	public UserDto getUserById(@PathVariable Integer userId) {
		return userService.getUserById(userId);
	}
}
