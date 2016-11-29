package com.capgemini.chess.service;

import javax.persistence.EntityManager;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.chess.dao.UserDao;
import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.service.UserRegistrationService;
import com.capgemini.chess.service.UserService;
import com.capgemini.chess.service.mapper.UserProfileMapper;
import com.capgemini.chess.service.to.UserProfileTO;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional 
public class OptimisticLockingTest {

	@Autowired
	private UserService us;
	
	@Autowired
	private UserRegistrationService urs;
	
	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	private UserDao uDao;
	
	UserProfileMapper mapper = new UserProfileMapper();

	
	@Before
	public void setup() {
	
		UserEntity ue = new UserEntity();
		ue.setLogin("aaa");
		ue.setSurname("Kowal");
		ue.setPassword("aaa");
		uDao.save(ue);
	}
	
	
	@Test(expected = OptimisticLockException.class)
	public void shouldThrowOptimisticLockingException() {
	
		UserEntity user1 = UserProfileMapper.map(us.findUserById(1L));
		entityManager.detach(user1);
		UserEntity user2 = UserProfileMapper.map(us.findUserById(1L));
		entityManager.detach(user2);
		
		// when
		user1.setName ("Jan");
		user2.setName("Jonasz");

		entityManager.merge(user1);
		entityManager.flush();
		entityManager.merge(user2);

	}

}
