/**
 * 
 */
package com.flipkart.service;

/**
 * 
 */
public interface AdminGMSInterface {
	public void seeAllGymOwner();
	
	public void seeAllGyms();
	
	public boolean seePendingGymOwnerRequest();
	
	public boolean seePendingGymRequest();
	
	public boolean approveSingleOwnerRequest(String requestId);
	
	public boolean approveAllOwnerRequest();
	
	public boolean approveSingleGymRequest(String gymId);
	
	public boolean approveAllGymRequest();
	
	public void blockGymOwner(String gynOwnerId);
}
