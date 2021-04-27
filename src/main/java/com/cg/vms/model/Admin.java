package com.cg.vms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long adminId;
	private String password;
	
	public Admin() {
		super();
	}

	public Long getAdminId() {
		return adminId;
	}


	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Admin(Long adminId, String password) {
		super();
		this.adminId = adminId;
		this.password = password;
	}


	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", password=" + password + "]";
	}


	
	
}