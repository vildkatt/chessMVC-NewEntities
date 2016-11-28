package com.capgemini.chess.service.to;


import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class UserStatisticsTO {

	@NotNull
	@NotEmpty
	long statisticsId;
	
	long numberOfGamesPlayed;
	
	long numberOfGamesWon;
	
	long numberOfGamesLost;
	

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
}
