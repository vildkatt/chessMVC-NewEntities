package com.capgemini.chess.service;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.chess.dao.UserDao;
import com.capgemini.chess.exceptions.EntityNotFoundException;
import com.capgemini.chess.exceptions.WrongParameterException;
import com.capgemini.chess.service.to.UserProfileTO;
import com.capgemini.chess.utils.UserSearchCriteria;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional 

public class UserServiceTest {

	@Autowired
	UserService us;

	@Autowired
	UserDao dao;

	@Test
	public void shouldFindUserWithId1(){
		//given
		long id = 1L;
		//when
		UserProfileTO user = us.findUserById(id);
		//then
		Assert.assertNotNull(user);
		Assert.assertTrue("login".equals(user.getLogin()));
	}

	@Test
	public void shouldFindUserBySurname(){
		String surname = "Nowak";
		List<UserProfileTO> users = us.findUserBySurname(surname);
		//then
		Assert.assertNotNull(users.get(0));
		Assert.assertTrue(surname.equals(users.get(0).getSurname()));
	}

	@Test
	public void shouldFindUserEntityByLogin(){
		String login = "login";
		UserProfileTO user = us.findUserEntityByLogin(login);
		//then
		Assert.assertNotNull(user);
		Assert.assertTrue(login.equals(user.getLogin()));
		Assert.assertTrue("Kowalski".equals(user.getSurname()));
	}

	@Test
	public void shouldFindUsersInATeam(){
		List<UserProfileTO> users = us.findUsersInATeam("111");
		//then
		Assert.assertEquals(2,users.size());
	}

	@Test(expected=EntityNotFoundException.class)
	public void shouldThrowExceptionWhenNoUsersFoundInTeam(){
		List<UserProfileTO> users = us.findUsersInATeam("FAKE_TEAM_NAME");
	}

	@Test(expected=WrongParameterException.class)
	public void shouldThrowWrongParameterExceptionWhenTeamNameIsNull(){
		us.assignUserToATeam("somelogin", null);
	}

	@Test(expected=WrongParameterException.class)
	public void shouldThrowWrongParameterExceptionWhenTeamNameIsEmptyString(){
		us.assignUserToATeam("somelogin", "");
	}

	@Test(expected=WrongParameterException.class)
	public void shouldThrowWrongParameterExceptionWhenLoginIsEmptyString(){
		us.assignUserToATeam("", "Team_Name");
	}
	
	@Test(expected=WrongParameterException.class)
	public void shouldThrowWrongParameterExceptionWhenLoginIsNull(){
		us.assignUserToATeam(null, "Team_Name");
	}
	
	@Test
	public void shouldFindByCriteria(){
		
		UserSearchCriteria usc  = new UserSearchCriteria();
		usc.setLogin("login");
		usc.setEmail("email");
		usc.setSurname("Kowalski");
		
		
		us.findUserBySearchCriteria(usc);
		Assert.assertNotNull(us.findUserBySearchCriteria(usc));
		

	}

}
