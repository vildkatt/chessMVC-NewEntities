package com.capgemini.chess.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.chess.dao.UserDao;
import com.capgemini.chess.dao.impl.UserDaoImpl;
import com.capgemini.chess.service.impl.UserRegistrationServiceImpl;
import com.capgemini.chess.service.impl.UserServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class UserRegistrationServiceTest {

	@Autowired
	UserRegistrationService service;
	
	@Configuration
	static class UserRegistrationServiceTestContextConfiguration {
		@Bean
		public UserRegistrationService userRegistrationService() {
			return new UserRegistrationServiceImpl();
		}
		
		@Bean
		public UserDao userRegistrationDao() {
			return new UserDaoImpl();
		}
	}
	
	@Test (expected = RuntimeException.class)
	public void shouldThrowNewRuntimeExceptionWhenLoginNull() {
		service.isUserRegistered(null);
	}
	
}
