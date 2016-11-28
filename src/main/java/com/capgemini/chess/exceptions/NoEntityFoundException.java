package com.capgemini.chess.exceptions;

public class NoEntityFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7730942815994667113L;
	
	   //Parameterless Constructor
    public NoEntityFoundException() {}

    //Constructor that accepts a message
    public NoEntityFoundException (String message)
    {
       super(message);
    }

}
