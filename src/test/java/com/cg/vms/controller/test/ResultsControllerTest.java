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

@SpringBootTest(classes=VmsApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class ResultsControllerTest {

			@Autowired
			private TestRestTemplate restTemplate;
			
			@LocalServerPort
			private int port;
			private String getRootUrl()
			{
				return "http://localhost:"+port;
			}
			
			@Test
			void testGetAllResults() {
				HttpHeaders header=new HttpHeaders();
				HttpEntity<String> entity=new HttpEntity<String>(null,header);
				ResponseEntity<String> response=restTemplate.exchange(getRootUrl()+"/api/v1/results/all",HttpMethod.GET,entity,String.class);
				assertNotNull(response.getBody());
			}

	

}
