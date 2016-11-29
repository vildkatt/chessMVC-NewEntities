package com.capgemini.chess.exceptions;

public class ParameterNotValidException extends RuntimeException {

	   /**
	 * 
	 */
	private static final long serialVersionUID = -1360556833684499207L;

	//Parameterless Constructor
    public ParameterNotValidException() {}

    //Constructor that accepts a message
    public ParameterNotValidException (String message)
    {
       super(message);
    }
}
