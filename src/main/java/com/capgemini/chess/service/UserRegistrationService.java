package com.capgemini.chess.service;

import com.capgemini.chess.service.to.UserProfileTO;

public interface UserRegistrationService {

	public boolean isUserRegistered (String login);
	
	public void registerUser (UserProfileTO userProfileTO);
	
	public void unregisterUser (long id);
	
}
