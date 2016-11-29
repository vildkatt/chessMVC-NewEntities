package com.capgemini.chess.dataaccess.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.capgemini.chess.dataaccess.entities.UserEntity;


@Entity
@Table (name="TEAMS")
@NamedQuery(name = "TeamEntity.findTeamByName", query = "select t from TeamEntity t where t.teamName = :teamName")
public class TeamEntity extends BaseEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3751880640396926847L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="TEAM_ID")
	private long teamId;

	@Column
	private String teamName;
	
	@ManyToMany (mappedBy = "teams", cascade=CascadeType.ALL)
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
	
	public TeamEntity() {
    	super();
}
	
}
