package com.capgemini.chess.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.dao.UserDao;
import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.service.UserRegistrationService;
import com.capgemini.chess.service.mapper.UserProfileMapper;
import com.capgemini.chess.service.to.UserProfileTO;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {

	@Autowired
	UserDao userDao;

	UserProfileMapper userProfileMapper = new UserProfileMapper();
	UserProfileTO userTO = new UserProfileTO();


	@Override
	public UserProfileTO registerUser(UserProfileTO userTO) {
		userDao.save(UserProfileMapper.map(userTO));
		String login = userTO.getLogin();
		return (UserProfileMapper.map(userDao.findUserByLogin(login)));
	}

	@Override
	public UserProfileTO findUserEntityByLogin(String login) {
		return UserProfileMapper.map(userDao.findUserByLogin(login));
	}

	@Override
	public void unregisterUser(UserProfileTO userTO) {
		userDao.delete(UserProfileMapper.map(userTO));
	}
	
	public UserProfileTO findUserBySurname(String surname) {
		return UserProfileMapper.map(userDao.findUserBySurname(surname));
	}
	

	public void setUserRegistrationDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void setUserProfileMapper(UserProfileMapper userProfileMapper) {
		this.userProfileMapper = userProfileMapper;
	}

}

