package com.capgemini.chess.service.to;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.capgemini.chess.dataaccess.entities.Level;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserProfileTO {
	
	@NotNull
	@NotEmpty	
	private long id;
	@NotNull
	@NotEmpty	
	private String login;
	@NotNull
	@NotEmpty	
	private String password;
	private String name;
	private String surname;
	private String email;
	@NotNull
	@NotEmpty	
	private Level level;
	
	private EmbeddedPersonalStatementTO personalStatementTO;
	
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
	
	@JsonIgnore
	public String getPassword() {
		return password;
	}
	
	@JsonProperty
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
	
	
	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public EmbeddedPersonalStatementTO getPersonalStatementTO() {
		return personalStatementTO;
	}

	public void setPersonalStatementTO(EmbeddedPersonalStatementTO personalStatementTO) {
		this.personalStatementTO = personalStatementTO;
	}

	
}
