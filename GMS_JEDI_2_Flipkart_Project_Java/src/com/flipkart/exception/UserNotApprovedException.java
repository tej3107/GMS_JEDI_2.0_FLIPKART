//package com.flipkart.exception;

package com.flipkart.exception;

import com.flipkart.bean.User;

/**
 * Exception to check if user is approved by administration
 *
 */
public class UserNotApprovedException extends Exception{
	
	private static final long serialVersionUID = 1L;
	private User userId;
	
	/**
	 * Constructor
	 * @param user
	 */
	public UserNotApprovedException(User user) {
		this.userId = user;
		System.out.println("user not found from exception\n");
	}

	/**
	 * Getter for userId
	 * @return
	 */
	public User getUserId() {
		return userId;
	}

}