package com.capgemini.chess.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jinq.jpa.JinqJPAStreamProvider;
import org.jinq.orm.stream.JinqStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.chess.dataaccess.entities.Level;
import com.capgemini.chess.dataaccess.entities.UserEntity;



@Repository
public class JinqDao {
	
	@Autowired
	EntityManager em;
	
	EntityManagerFactory entityManagerFactory = 
			  Persistence.createEntityManagerFactory("JPA");

	JinqJPAStreamProvider streams = 
			  new JinqJPAStreamProvider(entityManagerFactory);
			
			
	public List<UserEntity> findUsersByLevel (Level level) {		
					
					List<UserEntity> beginners = streams
					  .streamAll(em, UserEntity.class)
					  .where( c -> c.getLevel().equals(Level.BEGINNER) )
					  .toList(); 
					return beginners;
					}
	

}
