package com.capgemini.chess.batch;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTimeReport {


	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");


	
	//@Scheduled(fixedRate = 10000)
	public void reportCurrentTime() {
		
		System.out.println("The time is now " + dateFormat.format(new Date()));
	}
}
