package com.capgemini.chess.dao.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.capgemini.chess.dao.ChallengeDao;
import com.capgemini.chess.dataaccess.entities.ChallengeEntity;
import com.capgemini.chess.dataaccess.entities.ChallengeStatus;
import com.capgemini.chess.dataaccess.entities.Level;
import com.capgemini.chess.dataaccess.entities.UserEntity;

@Repository
public class ChallengeDaoImpl implements ChallengeDao {

	private List <UserEntity> users = new ArrayList <> ();
	private List <ChallengeEntity> challenges = new ArrayList <> ();

	public ChallengeDaoImpl() {

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
		c1.setChallengeStatus(ChallengeStatus.ACCEPTED);

		ChallengeEntity c2 = new ChallengeEntity();
		c2.setChallengeID(1);
		c2.setChallengingUser(u2);
		c2.setOpponent(u3);
		c2.setChallengeStatus(ChallengeStatus.REQUESTED);

		ChallengeEntity c3 = new ChallengeEntity();
		c3.setChallengeID(1);
		c3.setChallengingUser(u3);
		c3.setOpponent(u4);
		c3.setChallengeStatus(ChallengeStatus.ACCEPTED);

		ChallengeEntity c4 = new ChallengeEntity();
		c4.setChallengeID(1);
		c4.setChallengingUser(u4);
		c4.setOpponent(u2);
		c4.setChallengeStatus(ChallengeStatus.DENIED);

		ChallengeEntity c5 = new ChallengeEntity();
		c5.setChallengeID(1);
		c5.setChallengingUser(u3);
		c5.setOpponent(u1);
		c5.setChallengeStatus(ChallengeStatus.REQUESTED);

		challenges.add(c1);
		challenges.add(c2);
		challenges.add(c3);
		challenges.add(c4);
		challenges.add(c5);



	}

	@Override
	public Set<UserEntity> getUsersWithCorrectLevel(long userID, int level) {
		Set <UserEntity> usersForChallenge = new HashSet<>();
		for(UserEntity user:users){
			if(user.getId()==userID){
				continue; 
			}
			else if (user.getLevel().getValue() == level || user.getLevel().getValue() == level+1 || user.getLevel().getValue() == level-1) {
				usersForChallenge.add(user);
			}
		}

		return usersForChallenge;

	}



	@Override
	public Set <ChallengeEntity> findChallengeByStatus(ChallengeStatus challengeStatus) {
		Set <ChallengeEntity> challengesWithStatus = new HashSet<>();
		for (ChallengeEntity challenge: challenges) {
			if (challenge.getChallengeStatus().equals(challengeStatus)) {
				challengesWithStatus.add(challenge);
			}
		}
		return challengesWithStatus;
	}

	@Override
	public ChallengeEntity findChallengeByChallengingPlayer(UserEntity challengingPlayer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChallengeEntity findChallengeByOpponent(UserEntity opponent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateExpiredChallenges() {
		SimpleDateFormat currentDate = new SimpleDateFormat();
		System.out.println(currentDate);

		SimpleDateFormat expirationDate = new SimpleDateFormat("05:00:00");
		System.out.println(expirationDate);



		Set <ChallengeEntity> expiredChallenges = new HashSet<>();

		//		for (ChallengeEntity challenge: challenges) {
		//			if (challenge.getDateOfChallengeRequest()) {
		//				challengesWithStatus.add(challenge);
		//			}
		//		}
		//		return challengesWithStatus;

	}



	@Override
	public ChallengeEntity createChallengeManually(UserEntity challengingPlayer, UserEntity opponent,
			SimpleDateFormat challengeRequestDate) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<UserEntity> getUsers() {
		return users;
	}

	public List<ChallengeEntity> getChallenges() {
		return challenges;
	}


}
