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
import com.cg.vms.model.Voter;

@SpringBootTest(classes=VmsApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class VoterControllerTest {

		@Autowired
		private TestRestTemplate restTemplate;
		
		@LocalServerPort
		private int port;
		private String getRootUrl()
		{
			return "http://localhost:"+port;
		}
		
		@Test
		void testCreateVoter() {
			Voter voter=new Voter();
			voter.setVoterID(2);
			voter.setVoterName("kane");
			voter.setVoterAge(24);
			voter.setVoterCity("chennai");
			voter.setVoterPhone("9876543210");
			voter.setVoterIdProof("abdfrr");
			voter.setEmail("kane@gmail.com");
			voter.setPassword("kane1234");
			ResponseEntity<Voter> postResponse=restTemplate.postForEntity(getRootUrl()+"/api/v1/saveVoter", voter,Voter.class);
			assertNotNull(postResponse);
			assertNotNull(postResponse.getBody());
		}
		
		@Test
		void testGetAllVoters() {
			HttpHeaders header=new HttpHeaders();
			HttpEntity<String> entity=new HttpEntity<String>(null,header);
			ResponseEntity<String> response=restTemplate.exchange(getRootUrl()+"/api/v1/voters",HttpMethod.GET,entity,String.class);
			assertNotNull(response.getBody());
		}
		
		@Test
		void testGetVoterById() {
			Voter voter=new Voter();
			voter.setVoterID(2);
			voter.setVoterName("kane");
			voter.setVoterAge(24);
			voter.setVoterCity("chennai");
			voter.setVoterPhone("9876543210");
			voter.setVoterIdProof("abdfrr");
			voter.setEmail("kane@gmail.com");
			voter.setPassword("kane1234");
			restTemplate.postForEntity(getRootUrl()+"/api/v1/saveVoter", voter,Voter.class);
			Voter vot=restTemplate.getForObject(getRootUrl()+"/api/v1/2",Voter.class);
			assertNotNull(vot);
		}
		
		@Test
		void testUpdateVoter() {
			Voter vot=restTemplate.getForObject(getRootUrl()+"/api/v1/2",Voter.class);
	        vot.setVoterID(2);
			restTemplate.put(getRootUrl()+"/api/v1/update/2", vot);
			Voter updateVoter=restTemplate.getForObject(getRootUrl()+"/api/v1/2",Voter.class);
			assertNotNull(updateVoter);
		}
		
		@Test
		void testDeleteVoter() {
			Voter voter=new Voter();
			voter.setVoterID(2);
			voter.setVoterName("kane");
			voter.setVoterAge(24);
			voter.setVoterCity("chennai");
			voter.setVoterPhone("9876543210");
			voter.setVoterIdProof("abdfrr");
			voter.setEmail("kane@gmail.com");
			voter.setPassword("kane1234");
			ResponseEntity<Voter> postResponse=restTemplate.postForEntity(getRootUrl()+"/api/v1/saveVoter", voter,Voter.class);
			assertNotNull(postResponse);
			restTemplate.delete(getRootUrl()+"/api/v1/delete/2");
				Voter vot1=restTemplate.getForObject(getRootUrl()+"/api/v1/201",Voter.class);
				assertNotEquals(voter,vot1);
		}


}
