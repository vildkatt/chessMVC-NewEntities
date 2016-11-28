package com.capgemini.chess.dataaccess.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapsId;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "USERS")
@NamedQuery(name="UserEntity.findAllUsers", query="select u from UserEntity u")

public class UserEntity extends BaseEntity implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3257881721379656897L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name = "USER_ID")
	private long id;
	@Column(nullable = false)
	private String login;
	@Column(nullable = false)
	private String password;
	private String name;
	private String surname;
	private String email;
	@OneToOne @MapsId
    private UserStatisticsEntity userStatistics;
	@Enumerated
	private Level level;
	
	@OneToMany(targetEntity=ChallengeEntity.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="challengingUser", orphanRemoval = true)
	private Set<ChallengeEntity> userChallenges = new HashSet<>();
	
	@OneToMany(targetEntity=ChallengeEntity.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="opponent", orphanRemoval = true)
	private Set<ChallengeEntity> opponentChallenges = new HashSet<>();
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="team_members", 
	joinColumns =  @JoinColumn(name="USER_ID"), 
	inverseJoinColumns = @JoinColumn(name="TEAM_ID"))
	public Set <TeamEntity> teams;
	
	@Embedded
	private EmbeddedPersonalStatement personalStatement;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public UserStatisticsEntity getUserStatistics() {
		return userStatistics;
	}
	public void setUserStatistics(UserStatisticsEntity userStatistics) {
		this.userStatistics = userStatistics;
	}
	public Level getLevel() {
		return level;
	}
	public void setLevel(Level level) {
		this.level = level;
	}
	public EmbeddedPersonalStatement getPersonalStatement() {
		return personalStatement;
	}
	public void setPersonalStatement(EmbeddedPersonalStatement personalStatement) {
		this.personalStatement = personalStatement;
	}
	
    public Set<TeamEntity> getTeam() {
		return teams;
	}
	public void setTeam(Set<TeamEntity> teams) {
		this.teams = teams;
	}
	
	public UserEntity() {
    	super();
}
	
}
