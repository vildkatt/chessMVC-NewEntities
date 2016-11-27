package com.capgemini.chess.dataaccess.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.LastModifiedDate;

	@Entity
	@Table(name = "CHALLENGES")
	public class ChallengeEntity extends BaseEntity implements Serializable {		
		
		/**
		 * 
		 */
		private static final long serialVersionUID = -7926473832017317127L;


		@Id @GeneratedValue(strategy=GenerationType.AUTO)
		private long challengeId;
		
		@ManyToOne (fetch=FetchType.LAZY)
		private UserEntity challengingUser;
		
		@ManyToOne (fetch=FetchType.LAZY)
		private UserEntity opponent;
		
		@Enumerated
		private ChallengeStatus challengeStatus;
		
		@Temporal(TemporalType.DATE)
		@Column(nullable = false)
		private Date dateOfChallengeRequest;
		
		@LastModifiedDate
		@Temporal(TemporalType.DATE)
		@Column(nullable = false)
		private Date dateOfChallengeStateModification;
		

		public long getChallengeID() {
			return challengeId;
		}

		public void setChallengeID(long challengeID) {
			this.challengeId = challengeID;
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

		public Date getDateOfChallengeStateModification() {
			return dateOfChallengeStateModification;
		}

		public void setDateOfChallengeStateModification(Date dateOfChallengeStateModification) {
			this.dateOfChallengeStateModification = dateOfChallengeStateModification;
		}

		
		public ChallengeEntity() {
	    	super();
	}
		
}
