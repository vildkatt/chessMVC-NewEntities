package com.capgemini.chess.service;

import java.util.Set;

import com.capgemini.chess.dataaccess.entities.ChallengeEntity;
import com.capgemini.chess.dataaccess.entities.ChallengeStatus;
import com.capgemini.chess.dataaccess.entities.Level;
import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.service.to.UserProfileTO;

public interface ChallengeService {

	Set <UserProfileTO> createUserSetForAutomaticChallenge (long userID, int level);
	
	boolean checkIfChallengeExists (ChallengeEntity challengeEntity);
	
	ChallengeEntity findChallengeByStatus (ChallengeStatus challengeStatus);
	
	ChallengeEntity findChallengeByRequestDate (ChallengeEntity challengeEntity);
	
	ChallengeEntity findChallengeByPlayers (ChallengeEntity challengeEntity);
	
	ChallengeEntity requestChallenge (UserEntity userEntity, UserEntity opponent);
	
	ChallengeEntity declineChallenge (ChallengeEntity challengeEntity);
	
	ChallengeEntity acceptChallenge (ChallengeEntity challengeEntity);

	Set<UserProfileTO> createUserSetForAutomaticChallenge(Level level);
	
	
	
	
	
}
