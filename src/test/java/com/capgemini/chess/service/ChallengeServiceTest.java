package com.capgemini.chess.service;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional 
public class ChallengeServiceTest {

	
	@Autowired
	private ChallengeService cs;
	
	@Test
	public void should(){
		
	}
	
}
