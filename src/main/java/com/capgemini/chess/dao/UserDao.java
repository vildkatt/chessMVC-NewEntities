package com.capgemini.chess.dao;


import com.capgemini.chess.dataaccess.entities.UserEntity;

public interface UserDao extends Dao<UserEntity, Long> {

	
	/** 
	 * Finds a user by login
	 * @param String login
	 */
	UserEntity findUserByLogin (String login);

	UserEntity findUserBySurname(String surname);

	

	
	
	
	
	

}
