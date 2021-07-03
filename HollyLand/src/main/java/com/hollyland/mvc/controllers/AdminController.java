package com.hollyland.mvc.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hollyland.mvc.models.Admin;
import com.hollyland.mvc.services.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	private final AdminService adminService;
	
	public AdminController(AdminService adminService) {
		this.adminService = adminService;
	}
	
	@RequestMapping("")
	public String showAdminLoginPage(@ModelAttribute(value="admin") Admin admin,
			HttpSession session) {
		Long adminId = (Long) session.getAttribute("adminId");
		if(adminId != null)
			return "redirect:/login";
		return "/admin/login.jsp";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@ModelAttribute(value="admin") Admin admin,
			@RequestParam(value="rememberMe") boolean rememberMe,
			HttpSession session) {
		if(rememberMe) {
			session.setAttribute("adminEmail", admin.getEmail());
			session.setAttribute("adminPassword", admin.getPassword());
		}
		boolean isAuthorized = this.adminService.isAuthorized(admin);
		if(isAuthorized) {
			session.setAttribute("adminId", admin.getId());
			return "redirect:/showAdminDashboardPage";
		}
		return "/admin/login.jsp";
	}
}
