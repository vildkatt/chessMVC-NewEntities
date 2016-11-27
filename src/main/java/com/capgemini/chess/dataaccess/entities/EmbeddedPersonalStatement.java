package com.capgemini.chess.dataaccess.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Lob;


public class EmbeddedPersonalStatement implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3139137974569121393L;
	
	
	@Lob
	@Column (name="ABOUT_ME", nullable = true)
	private String aboutMe;
	@Lob
	private String lifeMotto;
	public String getAboutMe() {
		return aboutMe;
	}
	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}
	public String getLifeMotto() {
		return lifeMotto;
	}
	public void setLifeMotto(String lifeMotto) {
		this.lifeMotto = lifeMotto;
	}

	
}
