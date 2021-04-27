package com.cg.vms.controller.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.cg.vms.VmsApplication;
import com.cg.vms.model.Admin;
import com.cg.vms.model.Voter;

@SpringBootTest(classes=VmsApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class AdminControllerTest {
	
			@Autowired
			private TestRestTemplate restTemplate;
			
			@LocalServerPort
			private int port;
			private String getRootUrl()
			{
				return "http://localhost:"+port;
			}
			
			@Test
			void testSaveAdmin() {
				Admin admin = new Admin();
				admin.setAdminId((long) 3);
				admin.setPassword("admin22");
				ResponseEntity<Admin> postResponse=restTemplate.postForEntity(getRootUrl()+"/api/v1/admin/add", admin,Admin.class);
				assertNotNull(postResponse);
				assertNotNull(postResponse.getBody());
			}
			
			@Test
			void testGetAllAdmins() {
				HttpHeaders header=new HttpHeaders();
				HttpEntity<String> entity=new HttpEntity<String>(null,header);
				ResponseEntity<String> response=restTemplate.exchange(getRootUrl()+"/api/v1/admin/all",HttpMethod.GET,entity,String.class);
				assertNotNull(response.getBody());
			}
			
			@Test
			void testGetAdminById() {
				Admin admin = new Admin();
				admin.setAdminId((long) 3);
				admin.setPassword("admin22");
				restTemplate.postForEntity(getRootUrl()+"/api/v1/admin/add", admin,Admin.class);
				Admin adm=restTemplate.getForObject(getRootUrl()+"/api/v1/admin/3",Admin.class);
				assertNotNull(adm);
			}
			
			@Test
			void testDeleteAdmin() {
				Admin admin = new Admin();
				admin.setAdminId((long) 3);
				admin.setPassword("admin22");
				ResponseEntity<Admin> postResponse=restTemplate.postForEntity(getRootUrl()+"/api/v1/admin/all", admin,Admin.class);
				assertNotNull(postResponse);
				restTemplate.delete(getRootUrl()+"/api/v1/admin/2");
					Admin adm1=restTemplate.getForObject(getRootUrl()+"/api/v1/201",Admin.class);
					assertNotEquals(admin,adm1);
			}


}
