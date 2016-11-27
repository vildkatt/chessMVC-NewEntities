package com.capgemini.chess.dao;

import java.util.Set;

import com.capgemini.chess.dataaccess.entities.Level;
import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.service.to.UserProfileTO;

public interface UserDao {

	boolean isUserRegistered(String login);

	void registerUser(UserProfileTO userProfileTO);

	void unregisterUser(long id);
	
	void loginUser (String login, String password);
	
	void logoffUser (String login);
	
	UserEntity findUserByLogin (String login);
	
	UserEntity findUserByLevel (Level level);

	Set<UserEntity> createUserSetForAutomaticChallenge(Level level);
	
	
	
	
	

}
