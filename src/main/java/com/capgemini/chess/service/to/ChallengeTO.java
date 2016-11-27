	package com.capgemini.chess.service.to;

	import java.text.SimpleDateFormat;

import javax.validation.constraints.NotNull;
	import org.hibernate.validator.constraints.NotEmpty;

import com.capgemini.chess.dataaccess.entities.ChallengeStatus;
import com.capgemini.chess.dataaccess.entities.Level;
import com.capgemini.chess.dataaccess.entities.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


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
		private SimpleDateFormat dateOfChallengeRequest;
		
		
		
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
		public ChallengeStatus getChallengeStatus() {
			return challengeStatus;
		}
		public void setChallengeStatus(ChallengeStatus challengeStatus) {
			this.challengeStatus = challengeStatus;
		}
		public SimpleDateFormat getDateOfChallengeRequest() {
			return dateOfChallengeRequest;
		}
		public void setDateOfChallengeRequest(SimpleDateFormat dateOfChallengeRequest) {
			this.dateOfChallengeRequest = dateOfChallengeRequest;
		}
		
		
}

		
		