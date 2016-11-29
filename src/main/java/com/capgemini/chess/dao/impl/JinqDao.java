package com.capgemini.chess.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.chess.dataaccess.entities.Level;
import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.jinq.JinqSource;



@Repository
public class JinqDao {
	
	@Autowired
	EntityManager em;
	
	@Autowired
	JinqSource jinqSource;
		

		public List<UserEntity> findUsersWithBeginnerLevel () {
			
			List<UserEntity> beginners = jinqSource.users(em)
					.where(u -> u.getLevel().equals(Level.BEGINNER))
							.toList();
			
			return beginners;
		}
	}

