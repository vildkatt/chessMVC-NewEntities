package com.capgemini.chess.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.capgemini.chess.dataaccess.entities.ChallengeEntity;
import com.capgemini.chess.dataaccess.entities.ChallengeStatus;
import com.capgemini.chess.dataaccess.entities.Level;
import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.service.to.ChallengeTO;
import com.capgemini.chess.service.to.UserProfileTO;

public interface ChallengeService {

	public boolean checkIfChallengeExists (ChallengeEntity challengeEntity);
	
	 /**
	  * @param challenge status
	  * @return set of challenges with the specified status
	  */
	public List<ChallengeTO> findChallengeByStatus (ChallengeStatus challengeStatus);
	
	/**
	  * @param user entities: challenging player and opponent
	  * @return all challenges of a specific player
	  */
	public Set <ChallengeEntity> findChallengeByPlayers (UserEntity challengingPlayer, UserEntity opponent);

	/**
	  * @param user entities: challenging player and opponent
	  * @return a set of users that are of correct level and can be selected as opponents
	  */
	public Set<UserProfileTO> createUserSetForAutomaticChallenge(UserProfileTO userProfileTO);

	 /**
	  * @param challenge entity, date
	  * @return challenge requested on a specific date
	  */
	public ChallengeEntity findChallengeByRequestDate(ChallengeEntity challengeEntity, Date date);
	
}
