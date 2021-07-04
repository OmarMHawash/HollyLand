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
public class AdminController {
	private final AdminService adminService;
	
	public AdminController(AdminService adminService) {
		this.adminService = adminService;
	}
	
	@RequestMapping("/admin")
	public String showAdminLoginPage(@ModelAttribute(name="admin") Admin admin,
			HttpSession session) {
		Long adminId = (Long) session.getAttribute("adminId");
		if(adminId != null)
			return "redirect:/admin/login";
		return "admin/login.jsp";
	}
	
	@RequestMapping(value="/admin/login", method=RequestMethod.POST)
	public String login(@ModelAttribute("admin") Admin admin,
			@RequestParam(name="email") String email,
			@RequestParam(name="password") String password,
			HttpSession session) {
		System.out.println(email);
		System.out.println(password);
		boolean isAuthorized = this.adminService.isAuthorized(email, password);
		if(isAuthorized) {
			admin = this.adminService.getAdminByEmail(email);
			session.setAttribute("adminId", admin.getId());
			return "redirect:/showAdminDashboardPage";
		}
		return "/admin/login.jsp";
	}
	
	@RequestMapping("/showAdminDashboardPage")
	public String showAdminDashboardPage() {
		return "admin/adminDashboard.jsp";
	}
}
