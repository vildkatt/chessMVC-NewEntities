package com.capgemini.chess.service;

import java.util.Date;
import java.util.List;

import com.capgemini.chess.dataaccess.entities.ChallengeEntity;
import com.capgemini.chess.dataaccess.entities.ChallengeStatus;
import com.capgemini.chess.service.to.ChallengeTO;

public interface ChallengeService {


	public List<ChallengeTO> findChallengeByStatus (ChallengeStatus challengeStatus);

	public List <ChallengeTO> findChallengeByPlayers (String login);

	public List <ChallengeTO> findChallengeByRequestDate(Date date);

	void sendChallengeToOpponent(ChallengeTO challengeTO);

	void cancelChallenge(ChallengeTO challengeTO);

	ChallengeEntity rejectChallenge(ChallengeEntity challenge);

	void acceptChallenge(long challengeId);
	
}
