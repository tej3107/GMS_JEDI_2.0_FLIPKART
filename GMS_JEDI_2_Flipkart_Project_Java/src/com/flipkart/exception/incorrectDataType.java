package com.flipkart.exception;

/**
 * Exception to check if course is already registered by student
 * @author JEDI-03
 *
 */
public class incorrectDataType extends Exception{
	
	private static final long serialVersionUID = 1L;
	private String datatype;
	
	/**
	 * Constructor
	 * @param courseCode
	 */
	public incorrectDataType(String datatype) {
		this.datatype = datatype;
	}
	
	
	
	/**
	 * Message returned when exception is thrown
	 */
	@Override
	public String getMessage() {
		return "Incorrect data type. please enter " + datatype;
	}

}