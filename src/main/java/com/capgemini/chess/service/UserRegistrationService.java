package com.capgemini.chess.service;

import com.capgemini.chess.service.to.UserProfileTO;

public interface UserRegistrationService {

	
	/** 
	 * Registers a new user in the database
	 * @param UserProfileTO
	 */
	public UserProfileTO registerUser (UserProfileTO userTO);
	
	/** 
	 * Removes a  user from the database
	 * @param String login
	 */
	public void unregisterUser (UserProfileTO userTO);


}
