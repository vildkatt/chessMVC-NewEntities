package com.capgemini.chess.dao.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.capgemini.chess.dao.UserDao;
import com.capgemini.chess.dataaccess.entities.Level;
import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.service.to.UserProfileTO;

@Repository

public class UserDaoImpl implements UserDao{

	Set <UserEntity> users = new HashSet <>();
	Set <UserEntity> usersSelectedForAChallenge = new HashSet <> ();
	
	@Override
	
	public boolean isUserRegistered(String login) {
		
		if (login == null){
			throw new RuntimeException ("Login can't be null");
		}
		for (UserEntity user : users) {
			if (user.getLogin().equals(login)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void registerUser(UserProfileTO userProfileTO) {
		
		
		
	}

	@Override
	public void unregisterUser(long id) {
		
		
	}

	@Override
	public void loginUser(String login, String password) {
		// TODO Auto-generated method stub
		//spring security
		
	}

	@Override
	public Set<UserEntity> createUserSetForAutomaticChallenge(Level level) {
		if (level == null){
			throw new RuntimeException ("Login can't be null");
		}
		for (UserEntity user : users) {
			if (user.getLevel().equals(level)) {
				usersSelectedForAChallenge.add(user);
			}
		}
		return usersSelectedForAChallenge;
	}
		
	

	@Override
	public void logoffUser(String login) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserEntity findUserByLogin(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserEntity findUserByLevel(Level level) {
		// TODO Auto-generated method stub
		return null;
	}
}
