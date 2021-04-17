package com.jpa.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.jpa.web.entity.AdminUser;
import com.jpa.web.repository.AdminUserRepository;
import com.jpa.web.security.CustomUserDetail;

public class CustomUserDetailServices implements UserDetailsService {
		
	
	@Autowired
	private AdminUserRepository adminRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
//		Mahasiswa user = userRepo.findByNim(username);		
//		if (user == null) {
//			throw new UsernameNotFoundException("User not found");
//		}
//		return new CustomUserDetail(user);
		
		
		AdminUser admin = adminRepo.findByUsername(username);		
		if (admin == null) {
			throw new UsernameNotFoundException("User not found");
		}
		return new CustomUserDetail(admin);
		
	}
}
