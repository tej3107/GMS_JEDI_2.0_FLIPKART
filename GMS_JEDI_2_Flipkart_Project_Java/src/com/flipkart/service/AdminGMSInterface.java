/**
 * 
 */
package com.flipkart.service;

/**
 * 
 */
public interface AdminGMSInterface {
	
	/**
	 * Displays all gym owners.
	 */
	public void seeAllGymOwner();
	
	/**
	 * Displays all gyms.
	 */
	public void seeAllGyms();
	
	/**
	 * Checks if there are pending gym owner requests.
	 *
	 * @return true if there are pending gym owner requests, false otherwise
	 */
	public boolean seePendingGymOwnerRequest();
	
	/**
	 * Checks if there are pending gym requests.
	 *
	 * @return true if there are pending gym requests, false otherwise
	 */
	public boolean seePendingGymRequest();
	
	/**
	 * Approves a single gym owner request with the specified request ID.
	 *
	 * @param requestId the ID of the gym owner request to approve
	 * @return true if the request is approved successfully, false otherwise
	 */
	public boolean approveSingleOwnerRequest(String requestId);
	
	/**
	 * Approves all pending gym owner requests.
	 *
	 * @return true if all requests are approved successfully, false otherwise
	 */
	public boolean approveAllOwnerRequest();
	
	/**
	 * Approves a single gym request with the specified gym ID.
	 *
	 * @param gymId the ID of the gym request to approve
	 * @return true if the request is approved successfully, false otherwise
	 */
	public boolean approveSingleGymRequest(String gymId);
	
	/**
	 * Approves all pending gym requests.
	 *
	 * @return true if all requests are approved successfully, false otherwise
	 */
	public boolean approveAllGymRequest();
	
	/**
	 * Blocks a gym owner with the specified owner ID.
	 *
	 * @param gymOwnerId the ID of the gym owner to block
	 */
	public void blockGymOwner(String gymOwnerId);
}