package com.capgemini.chess.exceptions;

public class WrongParameterException extends RuntimeException{

	   /**
	 * 
	 */
	private static final long serialVersionUID = 6970538506849020687L;

	//Parameterless Constructor
    public WrongParameterException() {}

    //Constructor that accepts a message
    public WrongParameterException (String message)
    {
       super(message);
    }
}
