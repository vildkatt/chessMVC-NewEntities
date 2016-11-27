package com.capgemini.chess.dataaccess.entities;

public enum Level {
	
	NEWBIE(1),
	WEAKLING(2),
	BEGINNER(3),
	EXPERIENCED_BEGINNER(4),
	MIDDLEBROW(5),
	EXPERIENCED_MIDDLEBORW(6),
	ADVANCED(7),
	PROFESSIONAL(8),
	MASTER(9),
	CHUCK_NORRIS_OF_CHESS(10);
	
	private final int value;


    Level(int value) {
    	this.value = value;
      
    }
    
	public int getValue() {
		return value;
	}

	
	public static Level getLevelByValue(int value) {
		for(Level level : Level.values())
	    {
	        if(level.getValue() == value) {
	        	return level;
	        }
	    }
	    return null;
	}
}
