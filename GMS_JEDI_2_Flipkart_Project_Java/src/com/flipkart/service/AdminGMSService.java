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
	
	public boolean seePendingGymOwnerRequest() {
		return adminDBService.fetchPedningGymOwnerRequests();
		
	}
	
	public boolean seePendingGymRequest() {
		return adminDBService.fetchPendingGymnasiumRequest();
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
	
	public void blockGymOwner(String gynOwnerId) {
		adminDBService.unApproveGymOwner(gynOwnerId);
	}
} 
