package com.jpa.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.web.entity.AdminUser;

import com.jpa.web.repository.AdminUserRepository;

@Service
public class ModelAdminUser implements ModelAdminUserInterface {

	
	
	@Autowired
	AdminUserRepository adminUserRepo;

	@Override
	public List<AdminUser> getAllAdminUser() {
		// TODO Auto-generated method stub
		return (List<AdminUser>) this.adminUserRepo.findAll();
	}

	@Override
	public AdminUser getAdminUserByUsername(String username) {
		// TODO Auto-generated method stub
		return this.adminUserRepo.findByUsername(username);
	}
	
	
	@Override
	public AdminUser addAdminUser(AdminUser adminuser) {
		// TODO Auto-generated method stub
		
		return  this.adminUserRepo.save(adminuser);
	
	}
	
	
	@Override
	public AdminUser getAdminUserById(String id) {
		// TODO Auto-generated method stub
		
		return 	((AdminUser)this.adminUserRepo.findByIdAdmin(Long.parseLong(id)));
		
		
	}

	@Override
	public void deleteAdminUser(String id) {
		// TODO Auto-generated method stub
		this.adminUserRepo.deleteById(Long.parseLong(id));
		
	}
}
