package com.cg.vms.service.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.vms.model.Admin;
import com.cg.vms.model.Voter;
import com.cg.vms.repository.AdminRepository;
import com.cg.vms.repository.VoterRepository;
import com.cg.vms.service.AdminService;
import com.cg.vms.service.VoterService;
@RunWith(SpringRunner.class)
@SpringBootTest
class AdminServiceTest {

	@MockBean
    private AdminRepository adminRepository;
	
	@Autowired
	private AdminService adminService;
	
	@Test
	void testCreateAdmin() throws Exception{
		Admin admin = new Admin();
	   	admin.setAdminId((long) 3);
	   	admin.setPassword("Marina12");
	   	 Mockito.when(adminRepository.save(admin)).thenReturn(admin);
	   	 assertThat(adminService.saveAdmin(admin)).isEqualTo(admin);               
	}
	
	@Test
	void testGetAllAdmins() throws Exception{
		Admin admin1 = new Admin();
	   	admin1.setAdminId((long) 3);
	   	admin1.setPassword("Marina12");
	   	
	   	Admin admin2 = new Admin();
	   	admin2.setAdminId((long) 4);
	   	admin2.setPassword("Marina12");
	   	
	    List<Admin> adminlist = new ArrayList<>();
	    adminlist.add(admin1);
	    adminlist.add(admin2);
	    
	    Mockito.when(adminRepository.findAll()).thenReturn(adminlist);  
	    assertThat(adminService.viewAllAdmins()).isEqualTo(adminlist);
	}

}
