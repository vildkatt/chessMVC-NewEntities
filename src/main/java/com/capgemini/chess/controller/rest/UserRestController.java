package com.capgemini.chess.controller.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
import com.capgemini.chess.service.UserRegistrationService;
import com.capgemini.chess.service.to.UserProfileTO;

/**
 * @author      NPIETRAS
 * @version     1.0
 * Rest controller to provide CRUD operations for User domain object
 */


@Controller
//@ResponseBody

public class UserRestController {
	
	@Autowired
	private UserRegistrationService userService;
	
	/** 
	 * Finds single user by login
	 * @param  login as a criterion to search for a user
     * @return transfer object representing a user
	 */
//	@RequestMapping (value="/find-by-login/{login}", method = RequestMethod.GET)
//	public UserProfileTO findUserByLogin (@PathVariable("login") String login) {
//		return userService.findUserEntityByLogin(login);
//	}
//	
	/** 
	 * Registers single user in the database
	 * @param  user to be persisted to a database represented as a transfer object
     * @return user that was successfully persisted to a database represented as transfer object
	 */
//	@RequestMapping (value="/register", method = RequestMethod.POST)
//	public UserProfileTO registerUser (@RequestBody UserProfileTO user) {
//		return userService.registerUser(user);
//	}
	
	/** 
	 * Removes single user from the database
	 * @param  user to be removed from the database
	 */
//	@RequestMapping (value="/unregister", method = RequestMethod.DELETE)
//	public void unregisterUser (@RequestBody UserProfileTO user){
//		userService.unregisterUser(user);
//	}
}