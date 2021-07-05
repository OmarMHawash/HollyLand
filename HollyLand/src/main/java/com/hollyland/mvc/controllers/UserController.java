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
	
	@RequestMapping("/city/1")
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
	@RequestMapping("/city/2")
	public String View2(Model model) {
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
	@RequestMapping("/city/3")
	public String viewNabl3us(Model model) {
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
	@RequestMapping("/city/4")
	public String vie4(Model model) {
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
	@RequestMapping("/city/5")
	public String viewa5us(Model model) {
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
	@RequestMapping("/city/6")
	public String viewN6s(Model model) {
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
	@RequestMapping("/city/7")
	public String view7s(Model model) {
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
