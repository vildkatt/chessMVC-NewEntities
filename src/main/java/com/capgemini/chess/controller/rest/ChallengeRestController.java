package com.capgemini.chess.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
import com.capgemini.chess.service.ChallengeService;
import com.capgemini.chess.service.to.ChallengeTO;


@Controller
//@ResponseBody
public class ChallengeRestController {

	@Autowired
	ChallengeService challengeService;
	
//	@RequestMapping (value= "/find-by-status", method = RequestMethod.GET)
	public List<ChallengeTO> findChallenge (ChallengeTO challengeTo){
		
		return challengeService.findChallengeByStatus(challengeTo.getChallengeStatus());
	}
	

	
}
