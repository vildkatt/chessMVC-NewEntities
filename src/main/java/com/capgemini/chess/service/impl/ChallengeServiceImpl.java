package com.capgemini.chess.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.dao.ChallengeDao;
import com.capgemini.chess.dataaccess.entities.ChallengeEntity;
import com.capgemini.chess.dataaccess.entities.ChallengeStatus;
import com.capgemini.chess.dataaccess.entities.Level;
import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.service.ChallengeService;
import com.capgemini.chess.service.to.UserProfileTO;

@Service
public class ChallengeServiceImpl implements ChallengeService {

	@Autowired
	private ChallengeDao challengeDao;
	
	@Override
	public Set <UserProfileTO> createUserSetForAutomaticChallenge (long userID, int level) {
		challengeDao.getUsersWithCorrectLevel(userID, level);
		
		

		
		return null;
	}

	@Override
	public boolean checkIfChallengeExists(ChallengeEntity challengeEntity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ChallengeEntity findChallengeByStatus(ChallengeStatus challengeStatus) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChallengeEntity findChallengeByRequestDate(ChallengeEntity challengeEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChallengeEntity findChallengeByPlayers(ChallengeEntity challengeEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChallengeEntity requestChallenge(UserEntity userEntity, UserEntity opponent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChallengeEntity declineChallenge(ChallengeEntity challengeEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChallengeEntity acceptChallenge(ChallengeEntity challengeEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<UserProfileTO> createUserSetForAutomaticChallenge(Level level) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setChallengeDao(ChallengeDao challengeDao) {
		this.challengeDao = challengeDao;
	}
	
	
	
}
