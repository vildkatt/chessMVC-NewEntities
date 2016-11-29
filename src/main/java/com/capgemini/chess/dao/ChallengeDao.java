package com.capgemini.chess.dao;


import java.util.Date;
import java.util.List;

import com.capgemini.chess.dataaccess.entities.ChallengeEntity;
import com.capgemini.chess.dataaccess.entities.ChallengeStatus;

public interface ChallengeDao extends Dao<ChallengeEntity, Long> {

	
	public List<ChallengeEntity> findChallengeByStatus (ChallengeStatus challengeStatus);
	
	public List <ChallengeEntity> findChallengeByChallengingPlayer (String login);
	
	void updateExpiredChallenges(long expirationDate);
	
	public List<ChallengeEntity> getChallenges();

	public List <ChallengeEntity> findChallengeByRequestDate(Date date);
	
}