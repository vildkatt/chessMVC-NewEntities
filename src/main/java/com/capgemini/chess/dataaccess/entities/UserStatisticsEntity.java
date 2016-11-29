package com.capgemini.chess.dataaccess.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "USER_STATISTICS")
public class UserStatisticsEntity extends BaseEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8160790922748269336L;

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column (name = "STATISTICS_ID")
	long statisticsId;
	
	@Column (nullable=false)
	long numberOfGamesPlayed;
	
	long numberOfGamesWon;
	
	long numberOfGamesLost;
	
	@OneToOne
	UserEntity user;
	

	public long getStatisticsId() {
		return statisticsId;
	}

	public void setStatisticsId(long statisticsId) {
		this.statisticsId = statisticsId;
	}

	public long getNumberOfGamesPlayed() {
		return numberOfGamesPlayed;
	}

	public void setNumberOfGamesPlayed(long numberOfGamesPlayed) {
		this.numberOfGamesPlayed = numberOfGamesPlayed;
	}

	public long getNumberOfGamesWon() {
		return numberOfGamesWon;
	}

	public void setNumberOfGamesWon(long numberOfGamesWon) {
		this.numberOfGamesWon = numberOfGamesWon;
	}

	public long getNumberOfGamesLost() {
		return numberOfGamesLost;
	}

	public void setNumberOfGamesLost(long numberOfGamesLost) {
		this.numberOfGamesLost = numberOfGamesLost;
	}

	
	public UserStatisticsEntity() {
    	super();
}
	
	

}
