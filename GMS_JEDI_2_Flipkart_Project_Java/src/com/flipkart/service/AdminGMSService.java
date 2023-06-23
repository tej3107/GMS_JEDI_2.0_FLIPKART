/**
 * 
 */
package com.flipkart.service;

import com.flipkart.bean.*;
import java.util.*;
import com.flipkart.dao.*;
import java.sql.ResultSet;

/**
 * 
 */
public class AdminGMSService implements AdminGMSInterface{
	
	AdminGMSDao adminDBService = new AdminGMSDao();
	
	public AdminGMSService() {
		
		
//		seeAllGyms();
	}
	
	public void seeAllGymOwner() {
		adminDBService.fetchGymOwnerDetails();
	}
	
	public void seeAllGyms() {
		adminDBService.fetchGymnasiumDetails();
	}
	
	public void seePendingGymOwnerRequest() {
		adminDBService.fetchPedningGymOwnerRequests();
	}
	
	public void seePendingGymRequest() {
		adminDBService.fetchPendingGymnasiumRequest();
	}
	
	public boolean approveSingleOwnerRequest(String requestId) {
		adminDBService.updateSingleGymOwnerRequests(requestId);
		return true;
	}
	
	public boolean approveAllOwnerRequest() {
		adminDBService.updateAllPendingGymOwnerRequests();
		return true;
	}
	
	public boolean approveSingleGymRequest(String gymId) {
		adminDBService.updateSingleGymnasiumRequests(gymId);
		return true;
	}
	
	
	public boolean approveAllGymRequest() {
		adminDBService.updateAllPendingGymnasiumRequests();
		return true;
	}
} 