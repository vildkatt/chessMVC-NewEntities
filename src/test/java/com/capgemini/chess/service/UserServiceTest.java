package com.capgemini.chess.service;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.chess.service.mapper.UserProfileMapper;
import com.capgemini.chess.service.to.UserProfileTO;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional 

public class UserServiceTest {

	@Autowired
	UserService us;

	@Test
	public void shouldFindUserWithId1(){
	//given
	long id = 1L;
	//when
	UserProfileTO user = us.findUserById(id);
	//then
	Assert.assertTrue("ccc".equals(user.getLogin()));
	}
	
	//@Test
	public void shouldFindUserBySearchCriteria() {
	//given
		
	//when
	//then
}
}
