package com.cg.vms.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.vms.model.Admin;
import com.cg.vms.repository.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepository adminRepository;
	
	
	public Admin saveAdmin(Admin admin) {
		return adminRepository.save(admin);
	}
	
	public List<Admin> viewAllAdmins() {
		return adminRepository.findAll();
	}
	public Optional<Admin> getAdminById(Long adminId) {
		return adminRepository.findById(adminId);
	}
	
	public void deleteAdmin(Admin admin) {
		adminRepository.delete(admin);
	}


}
