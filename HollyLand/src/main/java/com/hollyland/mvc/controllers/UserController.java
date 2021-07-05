package com.hollyland.mvc.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hollyland.mvc.models.City;
import com.hollyland.mvc.services.UserService;

@Controller
public class UserController {
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping("/")
	public String viewHome() {
	return "home/homepage.jsp";
	}
	@RequestMapping("/village")
	public String viewvillage() {
	return "home/village.jsp";
	}
	
	@RequestMapping("/city/nablus")
	public String viewNablus(Model model) {
		City city = userService.findCityById(1);
		model.addAttribute("city", city);
//		List<Village> villages = city.get;
		ArrayList<String> villages = new ArrayList<String>();
		villages.add("tell");
		villages.add("Iraq-Burin");
		villages.add("tell");
		villages.add("Iraq-Burin");
		villages.add("tell");
		villages.add("Iraq-Burin");
		villages.add("other");


		model.addAttribute("villages",villages);		
	return "home/homepage.jsp";
	}
	
}
