package com.cg.vms.service.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.vms.model.Results;
import com.cg.vms.model.Voter;
import com.cg.vms.repository.ResultRepository;
import com.cg.vms.repository.VoterRepository;
import com.cg.vms.service.ResultService;
import com.cg.vms.service.VoterService;

@RunWith(SpringRunner.class)
@SpringBootTest

class ResultsServiceTest {

	@MockBean
    private ResultRepository resultRepository;
	
	@Autowired
	private ResultService resultService;
	
	@Test
	void testSaveResult() throws Exception{
		Results results = new Results();
		results.setCandidateId((long) 3);
		results.setName("MARINA");
		results.setConstituency("Chennai");
		results.setParty("BBB");
		results.setNoOfVotes(3);
	   	 Mockito.when(resultRepository.save(results)).thenReturn(results);
	   	 assertThat(resultService.saveResult(results)).isEqualTo(results);               
	}
	
	@Test
	void testGetAllResults() throws Exception{
		Results results1 = new Results();
		results1.setCandidateId((long) 3);
		results1.setName("MARINA");
		results1.setConstituency("Chennai");
		results1.setParty("BBB");
		results1.setNoOfVotes(3);
	   	
		Results results2 = new Results();
		results2.setCandidateId((long) 4);
		results2.setName("MARINA");
		results2.setConstituency("Chennai");
		results2.setParty("BBB");
		results2.setNoOfVotes(4);
	   	
	    List<Results> resultslist = new ArrayList<>();
	    resultslist.add(results1);
	    resultslist.add(results2);
	    
	    Mockito.when(resultRepository.findAll()).thenReturn(resultslist);  
	    assertThat(resultService.viewAll()).isEqualTo(resultslist);
	}
	

}
