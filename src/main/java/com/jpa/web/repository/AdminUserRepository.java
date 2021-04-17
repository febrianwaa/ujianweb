package com.jpa.web.repository;

import org.springframework.data.repository.CrudRepository;

import com.jpa.web.entity.AdminUser;

public interface AdminUserRepository extends CrudRepository<AdminUser,  Long>{
		
	
	public AdminUser findByIdAdmin(Long id);
	public AdminUser findByUsername(String username);
}
