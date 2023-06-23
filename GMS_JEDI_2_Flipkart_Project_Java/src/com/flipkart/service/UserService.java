/**
 * 
 */
package com.flipkart.service;
import com.flipkart.bean.*;
import com.flipkart.dao.*;

/**
 * 
 */
public class UserService implements UserServiceInterface {
	UserGMSDao dbService = new UserGMSDao();
	
	public UserService() {
		
	}
	
	public boolean registerCustomer(Registration customerData) {
		return true;
	}
	
	public boolean registerGymOwner(Registration ownerData) {
		return true;
	}
	
	public int authenticateUser(User userData) {
		String userName = userData.getUserName();
		String password = userData.getPassword();
		
		return dbService.authenticateUser(userName, password);
	}
	
	public boolean logout(User userData) {
		return true;
	}
}
