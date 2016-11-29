package com.capgemini.chess.exceptions;

public class EntityNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7730942815994667113L;
	
	   //Parameterless Constructor
    public EntityNotFoundException() {}

    //Constructor that accepts a message
    public EntityNotFoundException (String message)
    {
       super(message);
    }

}
