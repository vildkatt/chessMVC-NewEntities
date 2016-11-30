package com.capgemini.chess.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.capgemini.chess.dao.UserDao;
import com.capgemini.chess.dataaccess.entities.Level;
import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.exceptions.EntityNotFoundException;
import com.capgemini.chess.utils.UserSearchCriteria;

@Repository
public class UserDaoImpl extends AbstractDao<UserEntity, Long> implements UserDao {

	
	public UserDaoImpl(){
		//init();
	}

	@Override
	public UserEntity findUserByLogin(String login) {
	
		TypedQuery<UserEntity> query = entityManager.createQuery(
				"select u from UserEntity u where u.login = :login",
				UserEntity.class);
		query.setParameter("login", login);
		return query.getSingleResult();
	}

	@Override
	public List<UserEntity> findUsersBySurname (String surname) {
		TypedQuery<UserEntity> query = entityManager.createQuery(
				"select user from UserEntity user where user.surname = :surname",
				UserEntity.class);
		query.setParameter("surname", surname);
		List <UserEntity> result = query.getResultList();
		
		if (result==null|| result.isEmpty()) {
			throw new EntityNotFoundException("No users found");
		}
		return result;
	}
	
	@Override
	public List<UserEntity> findUserBySearchCriteria(UserSearchCriteria searchCriteria) {
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<UserEntity> query = builder.createQuery(UserEntity.class);
		Root<UserEntity> empl = query.from(UserEntity.class);
		List<Predicate> predicates = new ArrayList<Predicate>();

		if (searchCriteria.getSurname() != null) {
			predicates.add(builder.equal(empl.get("surname"), searchCriteria.getSurname()));
		}
		if (searchCriteria.getLogin() != null) {
			predicates.add(builder.equal(empl.get("login"), searchCriteria.getLogin()));
		}
		if (searchCriteria.getEmail() != null) {
			predicates.add(builder.equal(empl.get("email"), searchCriteria.getEmail()));
		}
	
		query.select(empl).where(predicates.toArray(new Predicate[] {}));
		
		List <UserEntity> users = entityManager.createQuery(query).getResultList();
		
		if (users.isEmpty()) {
			throw new EntityNotFoundException("No users found");
		}

		return users;
	}
	@Override
	public List<UserEntity> findUsersInATeam(String teamName) {
			TypedQuery<UserEntity> query = entityManager.createQuery(
					"select user from UserEntity user left join user.teams teams where teams.teamName like :teamName",
					UserEntity.class);
			query.setParameter("teamName", teamName);
			return query.getResultList();
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
