package com.capgemini.chess.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.chess.service.impl.UserServiceImpl;
import com.capgemini.chess.service.to.UserProfileTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class UserServiceTest {

	@Autowired
	UserService service;

	@Configuration
	static class RankServiceTestContextConfiguration {
		@Bean
		public UserService userService() {
			return new UserServiceImpl();
		}
	}

	@Test
	public void testReadUserSuccessful() throws Exception {

		// when
		UserProfileTO userTO = service.readUser(1L);
		assertNotNull(userTO);
	}

}
