package com.jpa.web.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.jpa.web.entity.AdminUser;


public class CustomUserDetail implements UserDetails {

	//private Mahasiswa user;
    
	private AdminUser admin;
    
    
    public CustomUserDetail(AdminUser admin) {
        this.admin = admin;
    }
 
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
    	final List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        /*   if (enabled) {
               if (this.getUser().isAdmin()) {
                   authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
               }*/
       //        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
       //    }
    	
    	
    	switch (this.admin.getRole()) {
		case "admin":
			authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
			break;

		case "user":
			authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
			break;
		}
    	
   
               return authorities;
    }
 
    @Override
    public String getPassword() {
        return admin.getPassword();
    }
 
    @Override
    public String getUsername() {
        return admin.getUsername();
    }
 
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
 
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
 
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
 
    @Override
    public boolean isEnabled() {
        return true;
    }
     
    
    public String getFullName() {
        return admin.getUsername();
    }
	
	
	
}
