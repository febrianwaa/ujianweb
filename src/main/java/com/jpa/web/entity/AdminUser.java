package com.jpa.web.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.jpa.web.entity.AdminUser;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="admin_user")
public class AdminUser {

	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	
	private long idAdmin;
	private String username;
	private String password;
	private String role;
	
	
}
