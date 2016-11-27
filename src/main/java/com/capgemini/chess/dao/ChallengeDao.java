package com.capgemini.chess.dao;

import java.text.SimpleDateFormat;
import java.util.Set;

import com.capgemini.chess.dataaccess.entities.ChallengeEntity;
import com.capgemini.chess.dataaccess.entities.ChallengeStatus;
import com.capgemini.chess.dataaccess.entities.Level;
import com.capgemini.chess.dataaccess.entities.UserEntity;

public interface ChallengeDao {

	
	public Set <ChallengeEntity> findChallengeByStatus (ChallengeStatus challengeStatus);
	
	public ChallengeEntity findChallengeByChallengingPlayer (UserEntity challengingPlayer);
	
	public ChallengeEntity findChallengeByOpponent (UserEntity opponent);
	

	public void updateExpiredChallenges ();
	
	public ChallengeEntity createChallengeManually (UserEntity challengingPlayer, UserEntity opponent, SimpleDateFormat challengeRequestDate);

	public Set <UserEntity> getUsersWithCorrectLevel(long userID, int level);
	

	
}