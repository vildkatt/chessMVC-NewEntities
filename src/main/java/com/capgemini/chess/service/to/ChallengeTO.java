	package com.capgemini.chess.service.to;


import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.capgemini.chess.dataaccess.entities.ChallengeStatus;
import com.capgemini.chess.dataaccess.entities.UserEntity;

public class ChallengeTO {
		
		@NotNull
		@NotEmpty	
		private long challengeID;
		@NotNull
		@NotEmpty	
		private UserEntity challengingUser;
		@NotNull
		@NotEmpty	
		private UserEntity opponent;
		@NotNull
		@NotEmpty	
		private ChallengeStatus challengeStatus;
		@NotNull
		@NotEmpty
		private Date dateOfChallengeRequest;
		
		
		
		public long getChallengeID() {
			return challengeID;
		}
		public void setChallengeID(long challengeID) {
			this.challengeID = challengeID;
		}
		

		public UserEntity getChallengingUser() {
			return challengingUser;
		}
		public void setChallengingUser(UserEntity challengingUser) {
			this.challengingUser = challengingUser;
		}
		public UserEntity getOpponent() {
			return opponent;
		}
		public void setOpponent(UserEntity opponent) {
			this.opponent = opponent;
		}
		public ChallengeStatus getChallengeStatus() {
			return challengeStatus;
		}
		public void setChallengeStatus(ChallengeStatus challengeStatus) {
			this.challengeStatus = challengeStatus;
		}
		public Date getDateOfChallengeRequest() {
			return dateOfChallengeRequest;
		}
		public void setDateOfChallengeRequest(Date dateOfChallengeRequest) {
			this.dateOfChallengeRequest = dateOfChallengeRequest;
		}
	
		
		
}

		
		