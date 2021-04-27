package com.cg.vms.controller.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import com.cg.vms.VmsApplication;
import com.cg.vms.model.Voter;
import com.cg.vms.model.VotingSession;

@SpringBootTest(classes=VmsApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class VotingSessionControllerTest {

			@Autowired
			private TestRestTemplate restTemplate;
			
			@LocalServerPort
			private int port;
			private String getRootUrl()
			{
				return "http://localhost:"+port;
			}
			
			@Test
			void testgetVotingSessionById() {
				VotingSession votingSession = new VotingSession();
				votingSession.setCandidateId(2);
				votingSession.setName("kane");
				votingSession.setConstituency("Chennai");
				votingSession.setParty("AAA");
				restTemplate.postForEntity(getRootUrl()+"/api/v1/candidate/add", votingSession,VotingSession.class);
				VotingSession vos=restTemplate.getForObject(getRootUrl()+"/api/v1/voting/2",VotingSession.class);
				assertNotNull(vos);
			}

}
