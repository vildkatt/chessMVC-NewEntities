package com.capgemini.chess.dao;


import java.util.Date;
import java.util.List;
import java.util.Set;

import com.capgemini.chess.dataaccess.entities.ChallengeEntity;
import com.capgemini.chess.dataaccess.entities.ChallengeStatus;
import com.capgemini.chess.dataaccess.entities.UserEntity;

public interface ChallengeDao extends Dao<ChallengeEntity, Long> {

	
	public List<ChallengeEntity> findChallengeByStatus (ChallengeStatus challengeStatus);
	
	public Set <ChallengeEntity> findChallengeByChallengingPlayer (UserEntity challengingPlayer);
	
	public Set <ChallengeEntity> findChallengesWithAnOpponent (UserEntity player, UserEntity opponent);

	void updateExpiredChallenges(long expirationDate);
	
	public List<ChallengeEntity> getChallenges();

	public ChallengeEntity findChallengeByRequestDate(ChallengeEntity challengeEntity, Date date);
	
}