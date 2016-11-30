package com.capgemini.chess.service;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.chess.service.to.UserProfileTO;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserRegistrationServiceTest {

	@Autowired
	private UserRegistrationService urs;

	@Autowired
	private UserService us;

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	@Test
	public void shouldRegisterUser() {

		UserProfileTO user = createUser();

		Assert.assertNull(us.findUserEntityByLogin("userLogin"));
		urs.registerUser(user);
		Assert.assertNotNull(us.findUserEntityByLogin("userLogin"));
	}

	@Test
	public void shouldUnregisterRegisterUser() throws Exception {

		UserProfileTO user = createUser();

		Assert.assertNull(us.findUserEntityByLogin("userLogin"));
		UserProfileTO registeredUser = urs.registerUser(user);
		Assert.assertNotNull(us.findUserEntityByLogin("userLogin"));
		urs.unregisterUser(registeredUser);
		Assert.assertNull(us.findUserEntityByLogin("userLogin"));
		// expectedEx.expect(com.capgemini.chess.exceptions.EntityNotFoundException.class);
		// expectedEx.expectMessage("No such user in the database");
	}

	@Test
	public void shouldThrowExceptionWhenTryToUnregisterNonExistingUser() {
		expectedEx.expect(com.capgemini.chess.exceptions.EntityNotFoundException.class);
		expectedEx.expectMessage("No such user in the database");

		UserProfileTO user = createUser();
		user.setId(888);

		urs.unregisterUser(user);
	}

	private UserProfileTO createUser() {
		UserProfileTO user = new UserProfileTO();
		user.setEmail("userEmail");
		user.setPassword("userPassword");
		user.setLogin("userLogin");
		return user;
	}

}
