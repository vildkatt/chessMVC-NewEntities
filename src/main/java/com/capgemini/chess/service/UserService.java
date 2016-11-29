package com.capgemini.chess.service;

import java.util.List;

import com.capgemini.chess.exceptions.WrongParameterException;
import com.capgemini.chess.service.to.UserProfileTO;
import com.capgemini.chess.utils.UserSearchCriteria;

public interface UserService {
	
	public UserProfileTO readUser(Long id);

	UserProfileTO findUserEntityByLogin(String login);

	UserProfileTO findUserBySurname(String surname);

	List<UserProfileTO> findUserBySearchCriteria(UserSearchCriteria searchCriteria);

	List<UserProfileTO> findUsersInATeam(String teamName);

	void assignUserToATeam(String login, String teamName) throws WrongParameterException;
	
}
