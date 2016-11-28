package com.capgemini.chess.service.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.capgemini.chess.dataaccess.entities.TeamEntity;
import com.capgemini.chess.service.to.TeamTO;


public class TeamMapper {

		public static TeamTO map(TeamEntity teamEntity) {
			if (teamEntity != null) {
				TeamTO teamTO = new TeamTO();
				teamTO.setTeamId(teamEntity.getTeamId());
				teamTO.setTeamName(teamEntity.getTeamName());
				teamTO.setMembers(teamEntity.getMembers());
				
				return teamTO;
			}
			return null;
		}

		public static TeamEntity map(TeamTO teamTO) {
			if (teamTO != null) {
				TeamEntity teamEntity = new TeamEntity();
				teamEntity.setTeamId(teamTO.getTeamId());
				teamEntity.setTeamName(teamTO.getTeamName());
				teamEntity.setMembers(teamTO.getMembers());
		
				return teamEntity;
			}
			return null;
		}
		
		public static TeamEntity update(TeamEntity teamEntity, TeamTO teamTO) {
			if (teamTO != null && teamEntity != null) {
				teamEntity.setTeamId(teamTO.getTeamId());
				teamEntity.setTeamName(teamTO.getTeamName());
				teamEntity.setMembers(teamTO.getMembers());
				
			}
			return teamEntity;
		}
		
		public static List<TeamTO> map2TOs(List<TeamEntity> teamEntities) {
			return teamEntities.stream().map(TeamMapper::map).collect(Collectors.toList());
		}

		public static List<TeamEntity> map2Entities(List<TeamTO> teamTOs) {
			return teamTOs.stream().map(TeamMapper::map).collect(Collectors.toList());
		}

}
