package com.capgemini.chess.service.to;

import java.util.Set;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.capgemini.chess.dataaccess.entities.UserEntity;

public class TeamTO {
	
	
	@NotNull
	@NotEmpty
	private long teamId;
	
	@NotNull
	@NotEmpty
	private String teamName;
	
	@NotNull
	@NotEmpty
	public Set <UserEntity> members;

	public long getTeamId() {
		return teamId;
	}

	public void setTeamId(long teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public Set<UserEntity> getMembers() {
		return members;
	}

	public void setMembers(Set<UserEntity> members) {
		this.members = members;
	}

	
}
