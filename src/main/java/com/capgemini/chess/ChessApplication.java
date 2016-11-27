package com.capgemini.chess;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.capgemini.chess.dao.ChallengeDao;

@EnableScheduling
@SpringBootApplication
public class ChessApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(ChessApplication.class, args);

	}
}
