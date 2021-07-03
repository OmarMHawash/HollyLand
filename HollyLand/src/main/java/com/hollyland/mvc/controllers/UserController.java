package com.hollyland.mvc.controllers;

import org.springframework.stereotype.Controller;

import com.hollyland.mvc.services.UserService;

@Controller
public class UserController {
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
}
