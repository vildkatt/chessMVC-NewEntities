package com.capgemini.chess.service.impl;

import java.util.Date;
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
import com.capgemini.chess.service.to.ChallengeTO;

@Service
public class ChallengeServiceImpl implements ChallengeService {

	@Autowired
	private ChallengeDao challengeDao;
	
	ChallengeMapper mapper = new ChallengeMapper();


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
	
	@Override
	public ChallengeEntity sendChallengeToOpponent(ChallengeTO challengeTO) {
		challengeDao.save(ChallengeMapper.map(challengeTO);
		
	}

	@Override
	public void cancelChallenge(ChallengeTO challengeTO) {
		challengeDao.delete(challenge);
	}

	@Override
	public ChallengeEntity acceptChallenge(ChallengeEntity challenge) {
		challenge.setAccepted(true);
		return challengeDao.update(challenge);
	}

	@Override
	public ChallengeEntity rejectChallenge(ChallengeEntity challenge) {
		challenge.setAccepted(false);
		return challengeDao.update(challenge);
	}

	@Override
	public ChallengeEntity findChallenge(Long challengeId) {
		return challengeDao.findOne(challengeId);
	}

	public void setChallengeDao(ChallengeDao challengeDao) {
		this.challengeDao = challengeDao;
	}

}
