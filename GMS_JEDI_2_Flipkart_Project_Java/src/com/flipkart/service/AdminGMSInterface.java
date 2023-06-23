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
	
	public void seePendingGymOwnerRequest();
	
	public void seePendingGymRequest();
	
	public boolean approveSingleOwnerRequest(String requestId);
	
	public boolean approveAllOwnerRequest();
	
	public boolean approveSingleGymRequest(String gymId);
	
	public boolean approveAllGymRequest();
}
