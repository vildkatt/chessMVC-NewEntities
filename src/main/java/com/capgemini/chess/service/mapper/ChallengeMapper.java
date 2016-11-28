package com.capgemini.chess.service.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.chess.dataaccess.entities.ChallengeEntity;
import com.capgemini.chess.service.to.ChallengeTO;


public class ChallengeMapper {
	public static ChallengeTO map(ChallengeEntity challengeEntity) {
		if (challengeEntity != null) {
			ChallengeTO challengeTO = new ChallengeTO();
			challengeTO.setChallengeID(challengeEntity.getChallengeID());
			challengeTO.setChallengeStatus(challengeEntity.getChallengeStatus());
			challengeTO.setChallengingUser(challengeEntity.getChallengingUser());
			challengeTO.setOpponent(challengeEntity.getOpponent());
			challengeTO.setDateOfChallengeRequest(challengeEntity.getDateOfChallengeRequest());
			return challengeTO;
		}
		return null;
	}

	public static ChallengeEntity map(ChallengeTO challengeTO) {
		if (challengeTO != null) {
			ChallengeEntity challengeEntity = new ChallengeEntity();
			challengeEntity.setChallengeID(challengeTO.getChallengeID());
			challengeEntity.setChallengeStatus(challengeTO.getChallengeStatus());
			challengeEntity.setChallengingUser(challengeTO.getChallengingUser());
			challengeEntity.setOpponent(challengeTO.getOpponent());
			challengeEntity.setDateOfChallengeRequest(challengeTO.getDateOfChallengeRequest());
			return challengeEntity;
		}
		return null;
	}
	
	public static ChallengeEntity update(ChallengeEntity challengeEntity, ChallengeTO challengeTO) {
		if (challengeTO != null && challengeEntity != null) {
			challengeEntity.setChallengeID(challengeTO.getChallengeID());
			challengeEntity.setChallengeStatus(challengeTO.getChallengeStatus());
			challengeEntity.setChallengingUser(challengeTO.getChallengingUser());
			challengeEntity.setOpponent(challengeTO.getOpponent());
			challengeEntity.setDateOfChallengeRequest(challengeTO.getDateOfChallengeRequest());
		}
		return challengeEntity;
	}
	
	public static List<ChallengeTO> map2TOs(List<ChallengeEntity> challengeEntities) {
		return challengeEntities.stream().map(ChallengeMapper::map).collect(Collectors.toList());
	}

	public static List<ChallengeEntity> map2Entities(List<ChallengeTO> challengeTOs) {
		return challengeTOs.stream().map(ChallengeMapper::map).collect(Collectors.toList());
	}
}



