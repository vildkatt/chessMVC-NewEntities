package com.capgemini.chess.dao;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.utils.UserSearchCriteria;

@Repository
public interface UserDao extends Dao <UserEntity, Long>{

	
	/** 
	 * Finds a user by login
	 * @param String login
	 */
	UserEntity findUserByLogin (String login);

	List <UserEntity> findUsersBySurname(String surname);

	List<UserEntity> findUserBySearchCriteria(UserSearchCriteria searchCriteria);

	List<UserEntity> findUsersInATeam(String teamName);

	

	
	
	
	
	

}
