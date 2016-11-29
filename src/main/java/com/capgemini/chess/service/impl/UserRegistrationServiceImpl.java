package com.capgemini.chess.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.dao.UserDao;
import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.exceptions.EntityNotFoundException;
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
		UserProfileTO userTOSave = UserProfileMapper.map(userDao.findUserByLogin(userTO.getLogin()));
		if (userTOSave != null) {
			throw new EntityNotFoundException("This login is already registered");
		}
		userDao.save(UserProfileMapper.map(userTOSave));
		String login = userTO.getLogin();
		return (UserProfileMapper.map(userDao.findUserByLogin(login)));
	}

	@Override
	public void unregisterUser(UserProfileTO userTO) {
		UserProfileTO userTORemove = UserProfileMapper.map(userDao.findOne(userTO.getId()));
			if (userTORemove == null) {
				throw new EntityNotFoundException("No such user in the database");
			}
			userDao.delete(UserProfileMapper.map(userTORemove));
	
	}

	

	public void setUserRegistrationDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void setUserProfileMapper(UserProfileMapper userProfileMapper) {
		this.userProfileMapper = userProfileMapper;
	}

}

