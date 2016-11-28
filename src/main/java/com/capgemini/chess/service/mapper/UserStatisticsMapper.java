package com.capgemini.chess.service.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.chess.dataaccess.entities.UserStatisticsEntity;
import com.capgemini.chess.service.to.UserStatisticsTO;

public class UserStatisticsMapper {
	
	public static UserStatisticsTO map(UserStatisticsEntity userStatistics) {
		if (userStatistics != null) {
			UserStatisticsTO statisticsTO = new UserStatisticsTO();
			statisticsTO.setStatisticsId(userStatistics.getStatisticsId());
			statisticsTO.setNumberOfGamesPlayed(userStatistics.getNumberOfGamesPlayed());
		
			
			return statisticsTO;
		}
		return null;
	}

	public static UserStatisticsEntity map(UserStatisticsTO statisticsTO) {
		if (statisticsTO != null) {
			UserStatisticsEntity userStatistics = new UserStatisticsEntity();
			userStatistics.setStatisticsId(statisticsTO.getStatisticsId());
			userStatistics.setNumberOfGamesPlayed(statisticsTO.getNumberOfGamesPlayed());
			
	
			return userStatistics;
		}
		return null;
	}
	
	public static UserStatisticsEntity update(UserStatisticsEntity userStatistics, UserStatisticsTO statisticsTO) {
		if (statisticsTO != null && userStatistics != null) {
			userStatistics.setNumberOfGamesPlayed(statisticsTO.getNumberOfGamesPlayed());
			
		}
		return userStatistics;
	}
	
	public static List<UserStatisticsTO> map2TOs(List<UserStatisticsEntity> userStatisticsList) {
		return userStatisticsList.stream().map(UserStatisticsMapper::map).collect(Collectors.toList());
	}

	public static List<UserStatisticsEntity> map2Entities(List<UserStatisticsTO> statisticsTOs) {
		return statisticsTOs.stream().map(UserStatisticsMapper::map).collect(Collectors.toList());
	}
}
