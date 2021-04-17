package com.jpa.web.services;

import java.util.List;

import com.jpa.web.entity.AdminUser;


public interface ModelAdminUserInterface {

	
	public List<AdminUser> getAllAdminUser();
	public AdminUser getAdminUserByUsername(String username);

	public AdminUser addAdminUser(AdminUser adminuser);
	public AdminUser getAdminUserById(String id);
	public void deleteAdminUser(String id);
}
