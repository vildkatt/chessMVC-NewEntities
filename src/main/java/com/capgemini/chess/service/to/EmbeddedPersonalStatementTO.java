package com.capgemini.chess.service.to;


import javax.persistence.Lob;

public class EmbeddedPersonalStatementTO {
	
	@Lob
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
