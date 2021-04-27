package com.cg.vms.service.test;

import static org.assertj.core.api.Assertions.assertThat;
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
import com.cg.vms.model.Voter;
import com.cg.vms.repository.VoterRepository;
import com.cg.vms.service.VoterService;



@RunWith(SpringRunner.class)
@SpringBootTest
class VoterServiceImplTest {
	
	@MockBean
    private VoterRepository voterRepository;
	
	@Autowired
	private VoterService voterService;
	
	@Test
	void testCreateVoter() throws Exception{
		Voter voter = new Voter();
	   	voter.setVoterID(1);
	   	voter.setVoterName("MARINA");
	   	voter.setEmail("mainas@gmail.com");
	   	voter.setVoterPhone("085126767");
	   	voter.setVoterCity("Cochin");
	   	voter.setVoterAge(23);
	   	 Mockito.when(voterRepository.save(voter)).thenReturn(voter);
	   	 assertThat(voterService.createVoter(voter)).isEqualTo(voter);               
	}

	@Test
	void testGetAllVoters() throws Exception{
		Voter voter1 = new Voter();
	   	voter1.setVoterID(1);
	   	voter1.setVoterName("MARINA");
	   	voter1.setEmail("mainas@gmail.com");
	   	voter1.setVoterPhone("085126767");
	   	voter1.setVoterCity("Cochin");
	   	voter1.setVoterAge(23);
	   	
	   	Voter voter2 = new Voter();
	   	voter2.setVoterID(2);
	   	voter2.setVoterName("MARINA");
	   	voter2.setEmail("mainas@gmail.com");
	   	voter2.setVoterPhone("085126767");
	   	voter2.setVoterCity("Cochin");
	   	voter2.setVoterAge(23);
	   	
	    List<Voter> voterlist = new ArrayList<>();
	    voterlist.add(voter1);
	    voterlist.add(voter2);
	    
	    Mockito.when(voterRepository.findAll()).thenReturn(voterlist);  
	    assertThat(voterService.getAllVoters()).isEqualTo(voterlist);
	}
	
	@Test
	void testDeleteVoter() throws Exception{
		Voter voter = new Voter();
	   	voter.setVoterID(1);
	   	voter.setVoterName("MARINA");
	   	voter.setEmail("mainas@gmail.com");
	   	voter.setVoterPhone("085126767");
	   	voter.setVoterCity("Cochin");
	   	voter.setVoterAge(23);
	    voterRepository.deleteById(voter.getVoterID());
	    System.out.println(voterRepository.findById(1));
	    Assert.assertTrue(voterRepository.findById(1).isEmpty());    
	} 
	
	@Test
	void testUpdateVoter() throws Exception{
		Voter voter2 = new Voter();
	   	voter2.setVoterID(2);
	   	voter2.setVoterName("MARINA");
	   	voter2.setEmail("mainas@gmail.com");
	   	voter2.setVoterPhone("085126767");
	   	voter2.setVoterCity("Cochin");
	   	voter2.setVoterAge(23);
	   	
	   	System.out.println(voter2.getVoterCity());
		voterRepository.findById(voter2.getVoterID());
		Assert.assertTrue(voterRepository.findById(1).isEmpty()); 
	}
  
}
