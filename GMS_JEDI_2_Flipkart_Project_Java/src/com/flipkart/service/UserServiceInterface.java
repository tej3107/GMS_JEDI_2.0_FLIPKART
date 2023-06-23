/**
 * 
 */
package com.flipkart.service;

import com.flipkart.bean.Registration;
import com.flipkart.bean.User;

/**
 * 
 */
public interface UserServiceInterface {
	public boolean registerCustomer(Registration customerData);
	
	public boolean registerGymOwner(Registration ownerData);
	
	public int authenticateUser(User userData);
	
	public boolean logout(User userData);
}