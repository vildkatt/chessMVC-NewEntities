package com.capgemini.chess.service.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.chess.dao.ChallengeDao;
import com.capgemini.chess.dataaccess.entities.ChallengeEntity;
import com.capgemini.chess.dataaccess.entities.ChallengeStatus;
import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.capgemini.chess.service.ChallengeService;
import com.capgemini.chess.service.mapper.ChallengeMapper;
import com.capgemini.chess.service.mapper.UserProfileMapper;
import com.capgemini.chess.service.to.ChallengeTO;
import com.capgemini.chess.service.to.UserProfileTO;

@Service
public class ChallengeServiceImpl implements ChallengeService {

	@Autowired
	private ChallengeDao challengeDao;

	@Override
	public Set<UserProfileTO> createUserSetForAutomaticChallenge(UserProfileTO userProfileTO) {

		Set<UserProfileTO> userProfileTOForChallenge = new HashSet<>();

		long userID = userProfileTO.getId();
		int level = userProfileTO.getLevel().getValue();

		Set<UserEntity> userEntityForChallenge = challengeDao.getUsersWithCorrectLevel(userID, level);

		for (UserEntity user : userEntityForChallenge) {
			UserProfileTO userTO = UserProfileMapper.map(user);
			userProfileTOForChallenge.add(userTO);
		}

		return userProfileTOForChallenge;
	}

	@Override
	public boolean checkIfChallengeExists(ChallengeEntity challengeEntity) {
		
		return false;
	}
	
	@Override
	public List<ChallengeTO> findChallengeByStatus(ChallengeStatus challengeStatus) {
		List<ChallengeTO> challenge = ChallengeMapper.map2TOs(challengeDao.findChallengeByStatus(challengeStatus));
		return challenge;
	}
	
	@Override
	public ChallengeEntity findChallengeByRequestDate(ChallengeEntity challengeEntity, Date date) {
		ChallengeEntity challenge = challengeDao.findChallengeByRequestDate(challengeEntity, date);
		return challenge;
	}

	@Override
	public Set<ChallengeEntity> findChallengeByPlayers(UserEntity challengingPlayer, UserEntity opponent) {

		Set<ChallengeEntity> challengesOfAnOpponent = challengeDao.findChallengesWithAnOpponent(challengingPlayer,
				opponent);
		return challengesOfAnOpponent;
	}

	public void setChallengeDao(ChallengeDao challengeDao) {
		this.challengeDao = challengeDao;
	}

}
