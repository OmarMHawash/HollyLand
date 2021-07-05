package com.hollyland.mvc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hollyland.mvc.models.Admin;
import com.hollyland.mvc.models.City;
import com.hollyland.mvc.models.Message;
import com.hollyland.mvc.models.Village;
import com.hollyland.mvc.repositories.AdminRepository;
import com.hollyland.mvc.repositories.CityRepository;
import com.hollyland.mvc.repositories.ImageRepository;
import com.hollyland.mvc.repositories.MessageRepository;
import com.hollyland.mvc.repositories.ReportRepository;
import com.hollyland.mvc.repositories.VillageRepository;

@Service
public class AdminService {
	private final AdminRepository adminRepository;
	private final CityRepository cityRepository;
	private final MessageRepository messageRepository;
	private final VillageRepository villageRepository;
	
	public AdminService(AdminRepository adminRepository, CityRepository cityRepository,
			ImageRepository imageRepository, MessageRepository messageRepository,
			ReportRepository reportRepository, VillageRepository villageRepository) {
		this.adminRepository = adminRepository;
		this.cityRepository = cityRepository;
		this.messageRepository = messageRepository;
		this.villageRepository = villageRepository;
	}
	
	public boolean isAuthorized(String email, String password) {
		String passwordToBeChecked = password;
		Admin admin = getAdminByEmail(email);
		String realPassword = admin.getPassword();
		if(admin != null)
			if(passwordToBeChecked.equals(realPassword))
				return true;
		return false;
	}
	
	public Admin getAdminByEmail(String email) {
		List<Admin> admins = this.adminRepository.findByEmail(email);
		return admins.get(0);
	}
	
	public void createAdmin(Admin admin) {
		this.adminRepository.save(admin);
	}
	
	public List<City> getCities(){
		return this.cityRepository.findAll();
	}
	
	public List<Village> getVillages(){
		return this.villageRepository.findAll();
	}
	
	public void createVillage(Village village) {
		this.villageRepository.save(village);
	}
	
	public List<Message> getMessages(){
		return this.messageRepository.findAll();
	}
	
	public void deleteMessage(Long messageId) {
		Message message = this.messageRepository.findById(messageId).orElse(null);
		this.messageRepository.delete(message);
	}
	
	public Village getvillageById(Long villageId) {
		return this.villageRepository.findById(villageId).orElse(null);
	}
}
