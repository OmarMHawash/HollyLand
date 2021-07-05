package com.hollyland.mvc.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hollyland.mvc.models.Admin;
import com.hollyland.mvc.models.Village;
import com.hollyland.mvc.services.AdminService;

@Controller
public class AdminController {
	private final AdminService adminService;
	
	public AdminController(AdminService adminService) {
		this.adminService = adminService;
	}
	
	@RequestMapping("/admin")
	public String showAdminLoginPage(HttpSession session,
			Model model) {
//		Admin admin = new Admin("barasalameh90@gmail.com","1234567890");
//		this.adminService.createAdmin(admin);
		Long adminId = (Long) session.getAttribute("adminId");
		System.out.println("admin id: "+adminId);
		if(adminId != null)
			return "redirect:/showAdminDashboardPage";
		return "/admin/login.jsp";
	}
		
	@RequestMapping(value="/admin/login", method=RequestMethod.POST)
	public String login(@RequestParam(name="email") String email,
			@RequestParam(name="password") String password,
			@RequestParam(name="rememberMe", required=false) String rememberMe,
			HttpSession session,
			Model model) {
		System.out.println("email: "+email);
		System.out.println("password: "+password);
		boolean isAuthorized = this.adminService.isAuthorized(email, password);
		if(rememberMe == "true") {
			session.setAttribute("email", email);
			session.setAttribute("password", password);
		}
		if(isAuthorized) {
			Admin admin = this.adminService.getAdminByEmail(email);
			session.setAttribute("adminId", admin.getId());
			return "redirect:/showAdminDashboardPage";
		}else {
			model.addAttribute("errors", "email or password is incorrect!");
		return "/admin/login.jsp";
		}
	}
	
	@RequestMapping("/showAdminDashboardPage")
	public String showAdminDashboardPage() {
		return "admin/adminDashboard.jsp";
	}
	@RequestMapping("/createVillage")
	public String addewVillage(@ModelAttribute("village") Village v) {
		
		return "admin/addNewVillage.jsp";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/admin";
	}
}
