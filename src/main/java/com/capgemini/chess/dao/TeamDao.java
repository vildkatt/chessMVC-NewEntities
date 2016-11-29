package com.capgemini.chess.dao;



import com.capgemini.chess.dataaccess.entities.TeamEntity;


public interface TeamDao extends Dao<TeamEntity, Long>{

	TeamEntity findTeamByName(String teamName);

}
