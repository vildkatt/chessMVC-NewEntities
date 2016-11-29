package com.capgemini.chess.dao.impl;


import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;


import com.capgemini.chess.dao.TeamDao;
import com.capgemini.chess.dataaccess.entities.TeamEntity;
import com.capgemini.chess.exceptions.EntityNotFoundException;

@Repository
public class TeamDaoImpl extends AbstractDao<TeamEntity, Long> implements TeamDao{

	@Override
	public TeamEntity findTeamByName (String teamName) {
		TypedQuery<TeamEntity> query = entityManager.createQuery(
				"select team from TeamEntity team where team.teamName = :teamName",
				TeamEntity.class);
		query.setParameter("teamName", teamName);
		TeamEntity result = query.getSingleResult();
		
		if (result==null) {
			throw new EntityNotFoundException("User not found");
		}
		return query.getSingleResult();
	}
}
