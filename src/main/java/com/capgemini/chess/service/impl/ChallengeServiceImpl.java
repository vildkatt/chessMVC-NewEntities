package com.capgemini.chess.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.dao.ChallengeDao;
import com.capgemini.chess.dataaccess.entities.ChallengeEntity;
import com.capgemini.chess.dataaccess.entities.ChallengeStatus;
import com.capgemini.chess.service.ChallengeService;
import com.capgemini.chess.service.mapper.ChallengeMapper;
import com.capgemini.chess.service.to.ChallengeTO;

@Service
public class ChallengeServiceImpl implements ChallengeService {

	@Autowired
	private ChallengeDao challengeDao;
	
	ChallengeMapper mapper = new ChallengeMapper();


	@Override
	public List<ChallengeTO> findChallengeByStatus(ChallengeStatus challengeStatus) {
		List<ChallengeTO> challenge = ChallengeMapper.map2TOs(challengeDao.findChallengeByStatus(challengeStatus));
		return challenge;
	}
	
	@Override
	public List <ChallengeTO> findChallengeByRequestDate(Date date) {
		List <ChallengeTO> challenge = ChallengeMapper.map2TOs(challengeDao.findChallengeByRequestDate(date));
		return challenge;
	}

	@Override
	public List <ChallengeTO> findChallengeByPlayers(String login) {
		
		List <ChallengeTO> challengesOfAnOpponent = ChallengeMapper.map2TOs(challengeDao.findChallengeByChallengingPlayer(login));
		return challengesOfAnOpponent;
	}
	
	@Override
	public void sendChallengeToOpponent(ChallengeTO challengeTO) {
		challengeDao.save(ChallengeMapper.map(challengeTO));
	}

	@Override
	public void cancelChallenge(ChallengeTO challengeTO) {
		challengeDao.delete(ChallengeMapper.map(challengeTO));
	}

	@Override
	public void acceptChallenge(long challengeId) {
		ChallengeTO challengeTO = ChallengeMapper.map(challengeDao.getOne(challengeId));
		challengeTO.setChallengeStatus(ChallengeStatus.ACCEPTED);
		challengeDao.save(ChallengeMapper.map(challengeTO));
		
	}

	@Override
	public ChallengeEntity rejectChallenge(ChallengeEntity challenge) {
		challenge.setChallengeStatus(ChallengeStatus.DENIED);
		return challengeDao.update(challenge);
	}


	public void setChallengeDao(ChallengeDao challengeDao) {
		this.challengeDao = challengeDao;
	}

}
