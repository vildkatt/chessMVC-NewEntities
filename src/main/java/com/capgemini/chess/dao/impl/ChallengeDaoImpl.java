package com.capgemini.chess.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.chess.dao.ChallengeDao;
import com.capgemini.chess.dataaccess.entities.ChallengeEntity;
import com.capgemini.chess.dataaccess.entities.ChallengeStatus;
import com.capgemini.chess.dataaccess.entities.Level;
import com.capgemini.chess.dataaccess.entities.UserEntity;


@Repository
public class ChallengeDaoImpl extends AbstractDao<ChallengeEntity, Long> implements ChallengeDao {

	private List<UserEntity> users = new ArrayList<>();
	private List<ChallengeEntity> challenges = new ArrayList<>();

	@Override
	public List<ChallengeEntity> findChallengeByStatus(ChallengeStatus challengeStatus) {
		List<ChallengeEntity> challengesWithStatus = new ArrayList<>();

		return challengesWithStatus;
	}

	@Override
	public List <ChallengeEntity> findChallengeByChallengingPlayer(String login) {
		TypedQuery<ChallengeEntity> query = entityManager.createQuery(
				"select challenge from ChallengeEntity challenge join fetch ChallengeEntity.challengingPlayer where challenge.challengingPlayer.login like :login",
				ChallengeEntity.class);
		query.setParameter("login", login);

		return query.getResultList();	
	}

	@Override
	public List <ChallengeEntity> findChallengeByRequestDate(Date dateOfChallengeRequest) {
		TypedQuery<ChallengeEntity> query = entityManager.createQuery(
				"select challenge from ChallengeEntity challenge where challenge.dateOfChallengeRequest like :dateOfChallengeRequest",
		ChallengeEntity.class);
		query.setParameter("dateOfChallengeRequest", dateOfChallengeRequest);

		return query.getResultList();	
		
	}

	@Override
	public void updateExpiredChallenges(long expirationDate) {
		Date currentDate = new Date();

		if (challenges == null || challenges.isEmpty()) {
			return;
		}

		for (ChallengeEntity challenge : challenges) {
			if (challenge.getDateOfChallengeRequest().getTime() + expirationDate < currentDate.getTime()) {
				// challenge.setChallengeStatus(ChallengeStatus.EXPIRED);
			}
		}
		currentDate = null;
	}

	public List<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}

	public List<ChallengeEntity> getChallenges() {
		return challenges;
	}

	public void setChallenges(List<ChallengeEntity> challenges) {
		this.challenges = challenges;
	}

	public final void initRepo() {

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

		users.add(u1);
		users.add(u2);
		users.add(u3);
		users.add(u4);

		ChallengeEntity c1 = new ChallengeEntity();
		c1.setChallengeID(1);
		c1.setChallengingUser(u1);
		c1.setOpponent(u2);
		c1.setDateOfChallengeRequest(new Date(1000));
		c1.setChallengeStatus(ChallengeStatus.ACCEPTED);

		ChallengeEntity c2 = new ChallengeEntity();
		c2.setChallengeID(1);
		c2.setChallengingUser(u2);
		c2.setOpponent(u3);
		c2.setDateOfChallengeRequest(new Date(1000));
		c2.setChallengeStatus(ChallengeStatus.REQUESTED);

		ChallengeEntity c3 = new ChallengeEntity();
		c3.setChallengeID(1);
		c3.setChallengingUser(u3);
		c3.setOpponent(u4);
		c3.setDateOfChallengeRequest(new Date());
		c3.setChallengeStatus(ChallengeStatus.ACCEPTED);

		ChallengeEntity c4 = new ChallengeEntity();
		c4.setChallengeID(1);
		c4.setChallengingUser(u4);
		c4.setOpponent(u2);
		c4.setDateOfChallengeRequest(new Date());
		c4.setChallengeStatus(ChallengeStatus.DENIED);

		ChallengeEntity c5 = new ChallengeEntity();
		c5.setChallengeID(1);
		c5.setChallengingUser(u3);
		c5.setOpponent(u1);
		;
		c5.setDateOfChallengeRequest(new Date());
		c5.setChallengeStatus(ChallengeStatus.REQUESTED);

		challenges.add(c1);
		challenges.add(c2);
		challenges.add(c3);
		challenges.add(c4);
		challenges.add(c5);
	}

}
