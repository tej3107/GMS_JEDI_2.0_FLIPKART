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
	
	/**
	 * Displays all gym owners.
	 */
	public void seeAllGymOwner() {
		adminDBService.fetchGymOwnerDetails();
	}
	
	/**
	 * Displays all gyms.
	 */
	public void seeAllGyms() {
		adminDBService.fetchGymnasiumDetails();
	}
	
	/**
	 * Checks if there are pending gym owner requests.
	 *
	 * @return true if there are pending gym owner requests, false otherwise
	 */
	public boolean seePendingGymOwnerRequest() {
		return adminDBService.fetchPedningGymOwnerRequests();
		
	}
	
	/**
	 * Checks if there are pending gym requests.
	 *
	 * @return true if there are pending gym requests, false otherwise
	 */
	public boolean seePendingGymRequest() {
		return adminDBService.fetchPendingGymnasiumRequest();
	}
	
	/**
	 * Approves a single gym owner request with the specified request ID.
	 *
	 * @param requestId the ID of the gym owner request to approve
	 * @return true if the request is approved successfully, false otherwise
	 */
	public boolean approveSingleOwnerRequest(String requestId) {
		adminDBService.updateSingleGymOwnerRequests(requestId);
		return true;
	}
	
	/**
	 * Approves all pending gym owner requests.
	 *
	 * @return true if all requests are approved successfully, false otherwise
	 */
	public boolean approveAllOwnerRequest() {
		adminDBService.updateAllPendingGymOwnerRequests();
		return true;
	}
	
	/**
	 * Approves a single gym request with the specified gym ID.
	 *
	 * @param gymId the ID of the gym request to approve
	 * @return true if the request is approved successfully, false otherwise
	 */
	public boolean approveSingleGymRequest(String gymId) {
		adminDBService.updateSingleGymnasiumRequests(gymId);
		return true;
	}
	
	/**
	 * Approves all pending gym requests.
	 *
	 * @return true if all requests are approved successfully, false otherwise
	 */
	public boolean approveAllGymRequest() {
		adminDBService.updateAllPendingGymnasiumRequests();
		return true;
	}
	
	/**
	 * Blocks a gym owner with the specified owner ID.
	 *
	 * @param gymOwnerId the ID of the gym owner to block
	 */
	public void blockGymOwner(String gynOwnerId) {
		adminDBService.unApproveGymOwner(gynOwnerId);
	}
}