package com.capgemini.chess.service;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.chess.dao.impl.JinqDao;
import com.capgemini.chess.dataaccess.entities.Level;
import com.capgemini.chess.dataaccess.entities.UserEntity;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional 
public class JinqQueryTest {

	@Autowired 
	JinqDao jinqDao;
	
	
	@Test
	public void shouldFindBeginnersJinq(){
		//when
		List<UserEntity> beginners = jinqDao.findUsersWithBeginnerLevel();
		//then
		Assert.assertEquals(1, beginners.size());
		Assert.assertEquals(Level.BEGINNER, beginners.get(0).getLevel().BEGINNER);
	}
}

