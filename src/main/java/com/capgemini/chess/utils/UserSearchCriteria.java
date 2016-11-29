package com.capgemini.chess.utils;

import com.capgemini.chess.dataaccess.entities.Level;

public class UserSearchCriteria {
	
	private String login;
	private String surname;
	private String email;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
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
	

}
