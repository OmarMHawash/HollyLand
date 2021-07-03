package com.hollyland.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hollyland.mvc.services.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	private final AdminService adminService;
	
	public AdminController(AdminService adminService) {
		this.adminService = adminService;
	}
	
	@RequestMapping("")
	public String showAdminLoginPage() {
		return "/admin/login.jsp";
	}
}
