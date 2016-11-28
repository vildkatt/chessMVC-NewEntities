package com.capgemini.chess.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.chess.dao.UserDao;
import com.capgemini.chess.dataaccess.entities.Level;
import com.capgemini.chess.dataaccess.entities.UserEntity;

@Repository

public class UserDaoImpl extends AbstractDao<UserEntity, Long> implements UserDao {

	
	public UserDaoImpl(){
		//init();
	}



	
	@Override
	public UserEntity findUserByLogin(String login) {
	
		TypedQuery<UserEntity> query = entityManager.createQuery(
				"select user from UserEntity user where user.login = :login",
				UserEntity.class);
		query.setParameter("login", login);
		return query.getSingleResult();
	}



	@Override
	public UserEntity findUserBySurname (String surname) {
		TypedQuery<UserEntity> query = entityManager.createQuery(
				"select user from UserEntity user where user.surname = :surname",
				UserEntity.class);
		query.setParameter("surname", surname);
		return query.getSingleResult();
	}
	
	
	private void init(){
		
		
		UserEntity u1 = new UserEntity();
		u1.setId(1);
		u1.setLogin("aaa");
		u1.setLevel(Level.ADVANCED);

		UserEntity u2 = new UserEntity();
		u2.setId(2);
		u2.setLogin("bbb");
		u2.setLevel(Level.NEWBIE);	

		UserEntity u3 = new UserEntity();
		u3.setId(3);
		u3.setLogin("ccc");
		u3.setLevel(Level.NEWBIE);

		UserEntity u4 = new UserEntity();
		u4.setId(3);
		u4.setLogin("ddd");
		u4.setLevel(Level.WEAKLING);


	}


}
