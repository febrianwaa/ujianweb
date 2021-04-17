package com.jpa.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.jpa.web.entity.AdminUser;
import com.jpa.web.services.ModelAdminUser;
@Controller
public class AdminUserPage {

	@Autowired
	ModelAdminUser modelAdminUser;
	
	
	@GetMapping("/adminuser/view")
	public String viewIndexAdminUser (Model model) {
		
		model.addAttribute("listAdminUser",modelAdminUser.getAllAdminUser());
		model.addAttribute("active",7);
		
		return "view_adminuser";
	}
	
	
	@GetMapping("/adminuser/add")
	public String viewAddAdminUser (Model model) {
		
		model.addAttribute("adminuser",new AdminUser ());
		
		return "add_adminuser";
	}
	
	
	@PostMapping("/adminuser/view")
	  public String addAdminUser(@ModelAttribute AdminUser adminuser, Model model) {
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String plainPassword = adminuser.getPassword();
		String encodedPassword = passwordEncoder.encode(plainPassword);
		adminuser.setPassword(encodedPassword);	
		
		
		
		// buat penampung data mahasiswa di halaman htmlnya
		this.modelAdminUser.addAdminUser(adminuser);
		model.addAttribute("listAdminUser", modelAdminUser.getAllAdminUser());
		
		
		return "view_adminuser";
	}
	
	
	
	@GetMapping("/adminuser/update/{id}")
	public String viewUpdateAdminUser(@PathVariable String id, Model model) {
		
		AdminUser adminuser = modelAdminUser.getAdminUserById(id);
		// buat penampung data mahasiswa di halaman htmlnya
		model.addAttribute("adminuser",adminuser);
		
		return "add_mahasiswa";
	}
	
	@GetMapping("/adminuser/delete/{id}")
	public String deleteAdminUser(@PathVariable String id, Model model) {
		
		this.modelAdminUser.deleteAdminUser(id);
		model.addAttribute("listAdminUser",modelAdminUser.getAllAdminUser());
		
		
		return "view_adminuser";
	}
	
	
}
