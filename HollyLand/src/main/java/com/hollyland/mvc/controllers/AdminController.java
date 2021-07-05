package com.hollyland.mvc.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hollyland.mvc.models.Admin;
import com.hollyland.mvc.models.City;
import com.hollyland.mvc.models.Message;
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
	public String showAdminDashboardPage(Model model) {
		List<City> cities = this.adminService.getCities();
		List<Village> villages = this.adminService.getVillages();
		List<Message> messages = this.adminService.getMessages();
		model.addAttribute("cities", cities);
		model.addAttribute("villages", villages);
		model.addAttribute("messages", messages);
		return "admin/adminDashboard.jsp";
	}
	
	@RequestMapping("/createVillage")
	public String addewVillage(@ModelAttribute("villages") Village v,
			HttpSession session,
			Model model) {
		Long adminId = (Long) session.getAttribute("adminId");
		if(adminId != null) {
			List<City> cities = this.adminService.getCities();
			model.addAttribute("cities", cities);
			return "admin/addNewVillage.jsp";
		}
			
		return "redirect:/admin";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/admin";
	}
	
	@RequestMapping(value="/addVillage", method=RequestMethod.POST)
	public String addVillage(@Valid @ModelAttribute(name="villages") Village village,
			BindingResult result,
			@RequestParam(name="city") City city,
			@RequestParam(name="name") String name,
			@RequestParam(name="space") float space,
			@RequestParam(name="population") int population,
			@RequestParam(name="description") String description) {
		if(result.hasErrors())
			return "/admin/addNewVillage.jsp";
		this.adminService.createVillage(village);
		return "redirect:/showAdminDashboardPage";
	}
	
	@RequestMapping("/deleteMessage/{messageId}")
	public String deleteMessage(@PathVariable("messageId") Long messageId,
			HttpSession session) {
		Long adminId = (Long) session.getAttribute("adminId");
		if(adminId != null) {
			this.adminService.deleteMessage(messageId);
			return "redirect:/showAdminDashboardPage";
		}
		return "redirect:/admin";
	}
	
	@RequestMapping(value="/adminEditVillage/{villageId}", method=RequestMethod.POST)
	public String showEditVillagePage(@ModelAttribute("villages") Village v,
			@PathVariable("villageId") Long villageId,
			Model model) {
		Village village = this.adminService.getvillageById(villageId);
		model.addAttribute("village", village);
		return "/admin/editVillage.jsp";
	}
}
