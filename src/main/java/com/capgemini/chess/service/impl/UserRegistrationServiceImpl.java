package com.capgemini.chess.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.dao.UserDao;
import com.capgemini.chess.service.UserRegistrationService;
import com.capgemini.chess.service.to.UserProfileTO;


@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {

	@Autowired
	UserDao userRegistrationDao;
	
	@Override
	public boolean isUserRegistered(String login) {
		return userRegistrationDao.isUserRegistered(login);
	}

	@Override
	public void registerUser(UserProfileTO userProfileTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unregisterUser(long id) {
		// TODO Auto-generated method stub
		
	}

	public void setUserRegistrationDao(UserDao userRegistrationDao) {
		this.userRegistrationDao = userRegistrationDao;
	}
}
