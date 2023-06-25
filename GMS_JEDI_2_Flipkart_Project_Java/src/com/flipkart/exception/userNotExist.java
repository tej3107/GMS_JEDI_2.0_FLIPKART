package com.flipkart.exception;

/**
 * Exception to check if course is already registered by student
 * @author JEDI-03
 *
 */
public class userNotExist extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor
	 * @param courseCode
	 */
	public userNotExist() {
		
	}
	
	
	/**
	 * Message returned when exception is thrown
	 */
	@Override
	public String getMessage() {
		return "Username or Password did'nt match ";
	}

}