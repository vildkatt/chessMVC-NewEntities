package com.capgemini.chess.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.dao.TeamDao;
import com.capgemini.chess.dao.UserDao;
import com.capgemini.chess.dataaccess.entities.TeamEntity;
import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.exceptions.EntityNotFoundException;
import com.capgemini.chess.exceptions.WrongParameterException;
import com.capgemini.chess.service.UserService;
import com.capgemini.chess.service.mapper.UserProfileMapper;
import com.capgemini.chess.service.to.UserProfileTO;
import com.capgemini.chess.utils.UserSearchCriteria;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;

	@Autowired
	TeamDao teamDao;
	
	UserProfileMapper userProfileMapper = new UserProfileMapper();
	UserProfileTO userTO = new UserProfileTO();
	
	
	@Override
	public UserProfileTO readUser(Long id) {

		return new UserProfileTO();
	}
	
	@Override
	public UserProfileTO findUserById(long id) {
		return UserProfileMapper.map(userDao.findOne(id));
	}
	
	
	@Override
	public UserProfileTO findUserEntityByLogin(String login) {
		return UserProfileMapper.map(userDao.findUserByLogin(login));
	}

	@Override
	public List <UserProfileTO> findUserBySurname(String surname) {
		if (surname=="") {throw new WrongParameterException ("User not found");}
		List <UserProfileTO> users = UserProfileMapper.map2TOs(userDao.findUsersBySurname(surname));
		if (users.isEmpty()) {throw new EntityNotFoundException("No users found");}
		return users;
	}
	
	@Override
	public List<UserProfileTO> findUserBySearchCriteria (UserSearchCriteria searchCriteria){
		List<UserEntity> userList = userDao.findUserBySearchCriteria(searchCriteria);
		if (userList.isEmpty()) {throw new EntityNotFoundException("No users specified by your criteria found");}
		return UserProfileMapper.map2TOs(userList);
		
	}
	
	@Override
	public  List<UserProfileTO> findUsersInATeam (String teamName) {
		List<UserEntity> userList = userDao.findUsersInATeam(teamName);
		if (userList.isEmpty()) {throw new EntityNotFoundException("No users found in the team");}
		return UserProfileMapper.map2TOs(userList);
	}
	
	@Override
	public void assignUserToATeam (String login, String teamName) throws WrongParameterException {
		if (login == null || login == ""|| teamName == null || teamName=="") {
			throw new WrongParameterException("You must provide correct login and name");
		}
		
		UserEntity user = userDao.findUserByLogin(login);
		if (user==null) {throw new EntityNotFoundException ("User not found");}
		TeamEntity team = teamDao.findTeamByName(teamName);
		if (team==null) {throw new EntityNotFoundException ("Team not found");}
		Set <TeamEntity> teams = user.getTeam();
		teams.add(team);
		user.setTeam(teams);
		userDao.update(user);
	}

	public UserDao getUserDao() {
		return userDao;
	}


	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	
}
